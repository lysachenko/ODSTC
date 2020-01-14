package com.netcracker.tc.client.ui.widget.simple;

import com.github.gwtbootstrap.client.ui.AlertBlock;
import com.github.gwtbootstrap.client.ui.TextArea;
import com.github.gwtbootstrap.client.ui.constants.AlertType;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Event;
import com.netcracker.tc.client.ui.widget.user.eventHandlers.*;


/*
 * before use the event insight this class
 * you must to set alertBlock variable
 * */

public class TextAreaHjb extends TextArea implements HasHandlers {
    private HandlerManager handlerManager;
    private AlertBlock alertBlock;
    private TextChangeEventHandler textChangeEventHandler;
    private FocusHandlerNew focusHandlerNew;
    private BlurHandlerNew blurHandlerNew;


    public TextAreaHjb() {
        super();
        // установка данного ел в обработчик событий
        handlerManager = new HandlerManager(this);

        // For all browsers - catch onKeyUp
        sinkEvents(Event.ONKEYUP);
        sinkEvents(Event.ONFOCUS);
        sinkEvents(Event.ONBLUR);

        // For IE and Firefox - catch onPaste
        sinkEvents(Event.ONPASTE);

        // For Opera - catch onInput
        setOnInputJSHandler(this.getElement());
        setBlurJSHandler(this.getElement());
        setFocusJSHandler(this.getElement());
        setDefaultListeners();
    }

    public void setAlertBlock(AlertBlock alertBlock) {
        this.alertBlock = alertBlock;
    }

    public void setTripleHandlers(TripleHandler tripleHandler) {
        addFocusEventHandler((FocusHandlerNew) tripleHandler);
        addBlurEventHandler((BlurHandlerNew) tripleHandler);
        addTextChangeEventHandler((TextChangeEventHandler) tripleHandler);
    }

    private void setDefaultListeners() {
        TripleHandler tripleHandler = new TripleHandler() {
            @Override
            public void onTextChange(TextChangeEvent textChangeEvent) {
                int len = getText().length();
                if (len > 4000) {
                    alertBlock.setType(AlertType.ERROR);
                } else {
                    alertBlock.setType(AlertType.INFO);
                }
                alertBlock.setText("Введено " + len + " символов из " + "4000");
                setHeight("auto");

                //getElement().getInnerText().length()
                if (getElement().getScrollHeight() < 500) {
                    setHeight(getElement().getScrollHeight() + "px");
                } else {
                    setHeight(500 + "px");
                }
            }

            @Override
            public void onFocus(FocusEventNew focusEventNew) {
                alertBlock.setVisible(true);
            }

            @Override
            public void onBlur(BlurEventNew blurEvent) {
                alertBlock.setVisible(false);
                setHeight(90 + "px");
            }
        };
        setTripleHandlers(tripleHandler);
    }

    // задание обработчика события Focus в нативном коде
    private native void setFocusJSHandler(Element element)/*-{
        var that = this;
        element.onblur = $entry(function (event) {
            that.@com.netcracker.tc.client.ui.widget.simple.TextAreaHjb::onFocusHandler(Lcom/google/gwt/user/client/Event;)(event);
            return false;
        });
    }-*/;

    // задание обработчика события блюр в нативном коде
    private native void setBlurJSHandler(Element element)/*-{
        var that = this;
        element.onblur = $entry(function (event) {
            that.@com.netcracker.tc.client.ui.widget.simple.TextAreaHjb::onBlurHandler(Lcom/google/gwt/user/client/Event;)(event);
            return false;
        });
    }-*/;

    private native void setOnInputJSHandler(Element element) /*-{
        var that = this;
        element.oninput = $entry(function (event) {
            that.@com.netcracker.tc.client.ui.widget.simple.TextAreaHjb::onInputHandler(Lcom/google/gwt/user/client/Event;)(event);
            return false;
        });
    }-*/;

    private void onInputHandler(Event event) {
        fireEvent(new TextChangeEvent());
    }

    // тригер события блюр
    private void onBlurHandler(Event event) {
        fireEvent(new BlurEventNew()); // тут я передаю по сути только класс события который потм использую в fireEvent
    }

    // тригер события Focus
    private void onFocusHandler(Event event) {
        fireEvent(new BlurEventNew()); // тут я передаю по сути только класс события который потм использую в fireEvent
    }

    public HandlerRegistration addTextChangeEventHandler(TextChangeEventHandler handler) {
        if (handlerManager.isEventHandled(TextChangeEvent.TYPE)) {
            handlerManager.removeHandler(TextChangeEvent.TYPE, textChangeEventHandler);
        }
        textChangeEventHandler = handler;
        return handlerManager.addHandler(TextChangeEvent.TYPE, handler);
    }

    // установка обработчика из вне
    public HandlerRegistration addBlurEventHandler(BlurHandlerNew handler) {
        if (handlerManager.isEventHandled(BlurEventNew.TYPE)) {
            handlerManager.removeHandler(BlurEventNew.TYPE, blurHandlerNew);
        }
        blurHandlerNew = handler;
        return handlerManager.addHandler(BlurEventNew.TYPE, handler);
    }

    // установка обработчика Focus из вне
    public HandlerRegistration addFocusEventHandler(FocusHandlerNew handler) {
        if (handlerManager.isEventHandled(FocusEventNew.TYPE)) {
            handlerManager.removeHandler(FocusEventNew.TYPE, focusHandlerNew);
        }
        focusHandlerNew = handler;
        return handlerManager.addHandler(FocusEventNew.TYPE, handler);
    }

    //тригер всех событий установленных ранее в handlerManager
    @Override
    public void fireEvent(GwtEvent<?> event) {
        handlerManager.fireEvent(event);
    }

    // запуск событий из браузера
    @Override
    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        if (alertBlock == null) {
        }
        switch (event.getTypeInt()) {
            case Event.ONKEYUP:
            case Event.ONPASTE: {
                // Scheduler needed so pasted data shows up in TextBox before we fire event
                Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                    @Override
                    public void execute() {
                        fireEvent(new TextChangeEvent());
                    }
                });
                break;
            }
            case Event.ONBLUR: {
                Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                    @Override
                    public void execute() {
                        fireEvent(new BlurEventNew());
                    }
                });
                break;
            }
            case Event.ONFOCUS: {
                // Scheduler - планировщик
                // передача планировщику задачи на выполнение
                // задача выполнится по возвращению цикла браузера
                Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                    @Override
                    public void execute() {
                        fireEvent(new FocusEventNew());
                        fireEvent(new TextChangeEvent());
                    }
                });
                break;
            }
            default:
                // Do nothing
        }
    }
}
