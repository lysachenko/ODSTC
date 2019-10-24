package com.netcracker.tc.server.service.impl;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.dom.DOMDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.netcracker.tc.server.service.api.SettingsService;
import com.netcracker.tc.server.service.exception.ServiceException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author anla1215
 */
@Component
public class SettingsServiceImpl implements SettingsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SettingsServiceImpl.class);

    private static final String SETTINGS_FOLDER = File.separator + "WEB-INF" + File.separator + "settings" + File.separator;
    private static final String SETTINGS_FILE = SETTINGS_FOLDER + File.separator + "general-config.xml";

    private static final String SETTINGS_KEY_CONFIGURATION = "configuration";
    private static final String SETTINGS_KEY_RECRUITMENT = "recruitment";
    private static final String SETTINGS_KEY_STATUS = "status";
    private static final String SETTINGS_KEY_BEFOREREGISTRATION = "beforeRegistration";
    private static final String SETTINGS_KEY_MESSAGE = "message";

    private static final String SETTINGS_VALUE_OPEN = "open";
    private static final String SETTINGS_VALUE_CLOSE = "close";
    
    private static final Map<String, Integer> SETTINGS_MAP;
    private static final Integer SETTINGS_ROOT = Integer.valueOf(0);
    private static final Integer SETTINGS_SECTION = Integer.valueOf(1);
    private static final Integer SETTINGS_PARAMETER = Integer.valueOf(2);
    static {
        SETTINGS_MAP = new HashMap<String, Integer>(3);
        SETTINGS_MAP.put(SETTINGS_KEY_CONFIGURATION, SETTINGS_ROOT);
        SETTINGS_MAP.put(SETTINGS_KEY_RECRUITMENT, SETTINGS_SECTION);
        SETTINGS_MAP.put(SETTINGS_KEY_STATUS, SETTINGS_PARAMETER);
        SETTINGS_MAP.put(SETTINGS_KEY_BEFOREREGISTRATION, SETTINGS_SECTION);
        SETTINGS_MAP.put(SETTINGS_KEY_MESSAGE, SETTINGS_PARAMETER);

    }

    private String settingsFilePath;
    private Document configFile;

    private Map<String, String> parameters = new HashMap<String, String>();

    public SettingsServiceImpl() {
    }

    @Autowired
    public void setServletContext(ServletContext servletContext) {
        settingsFilePath = servletContext.getRealPath("") + SETTINGS_FILE;

        File fXmlFile = new File(settingsFilePath);
        if (!fXmlFile.exists()) {
            try {
                fXmlFile.createNewFile();                
            } catch (IOException ex) {
                LOGGER.error("IOException: " + ex);
            }            
        }
        
        configFile = getConfigFile(fXmlFile);
        parameters = getParameters(configFile);        
    }

    @Override
    public String getBeforeRegistrationMessage() {
        return (parameters == null) ? "" : parameters.get(SETTINGS_KEY_MESSAGE);
    }

    @Override
    public void setBeforeRegistrationMessage(String message) throws ServiceException {
        parameters.put(SETTINGS_KEY_MESSAGE, message);
        updateParameters(configFile, parameters);
    }

    @Override
    public boolean getIsRegistrationOpen() {
        return SETTINGS_VALUE_OPEN.equals(parameters.get(SETTINGS_KEY_STATUS));
    }

    @Override
    public void setIsRegistrationOpen(boolean status) throws ServiceException {
        String value = status ? SETTINGS_VALUE_OPEN : SETTINGS_VALUE_CLOSE;
        parameters.put(SETTINGS_KEY_STATUS, value);
        updateParameters(configFile, parameters);
    }

    private Document getConfigFile(File file) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document configFile = dBuilder.parse(file);

            configFile.getDocumentElement().normalize();
            
            if(configFile.getElementsByTagName(SETTINGS_KEY_CONFIGURATION).getLength() == 0){
                createConfigFile(configFile);
            }
            
            return configFile;
        } catch (ParserConfigurationException ex) {
            LOGGER.error("Error while parsing configuration file!\nTrace: " + ex);
        } catch (SAXException ex) {
            LOGGER.error("SAX Exception: " + ex);
        } catch (IOException ex) {
            LOGGER.error("IOException: " + ex);
        }
        
        return null;
    }

    private Map<String, String> getParameters(Document configFile) {
        Map<String, String> parameters = new HashMap<String, String>();
        
        if (configFile == null) {
            LOGGER.error("Configuration file is null!");
            return null;
        }        
        
        Node root = configFile.getElementsByTagName(SETTINGS_KEY_CONFIGURATION).item(0);
        parseParameter(root, parameters);   

        return parameters;
    }
    
    private void parseParameter(Node element, Map<String, String> result){
        
        
        Integer mapType = getMAPType(element.getNodeName());
        if(mapType == SETTINGS_ROOT || mapType == SETTINGS_SECTION){
            NodeList childs = element.getChildNodes();
            for(int i = 0; i < childs.getLength(); i++){
                Node child = childs.item(i);
                if(child.getNodeType() == Node.ELEMENT_NODE){
                    parseParameter(child, result);
                }
            }
        }        
        
        if(mapType == SETTINGS_PARAMETER){
            String key = element.getNodeName();
            String value = element.getTextContent();
            result.put(key, value);
        }       
    }

    private void updateParameters(Document configFile, Map<String, String> parameters) throws ServiceException {
        try {
            for (String key : parameters.keySet()) {
                Node node = configFile.getElementsByTagName(key).item(0);
                String value = parameters.get(key);
                System.out.println("node: " + node);
                if (!node.getTextContent().equals(value)) {
                    node.setTextContent(value);
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(configFile);
            StreamResult result = new StreamResult(new File(settingsFilePath));
            transformer.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            LOGGER.error("TransformerConfigurationException: " + ex);
            throw new ServiceException(ex.toString());
        } catch (TransformerException ex) {
            LOGGER.error("TransformerException: " + ex);
            throw new ServiceException(ex.toString());
        }

    }

    private void createConfigFile(Document configFile) {
        Element configuration = configFile.createElement(SETTINGS_KEY_CONFIGURATION);
        configFile.appendChild(configuration);
        
        Element recruitment = configFile.createElement(SETTINGS_KEY_RECRUITMENT);
        configFile.appendChild(recruitment);
        
        Element status = configFile.createElement(SETTINGS_KEY_STATUS);
        status.setTextContent(SETTINGS_VALUE_CLOSE);
        configFile.appendChild(status);

    }
    
    private static Integer getMAPType(String name){
        return SETTINGS_MAP.get(name);
    }

}
