package com.brasco.simwechat.quickblox.managers;

/**
 * Created by Administrator on 11/11/2016.
 */
import com.quickblox.chat.exception.QBChatException;
import com.quickblox.chat.listeners.QBChatDialogMessageListener;
import com.quickblox.chat.model.QBChatMessage;

public class QbChatDialogMessageListenerImp implements QBChatDialogMessageListener {
    public QbChatDialogMessageListenerImp() {
    }

    @Override
    public void processMessage(String s, QBChatMessage qbChatMessage, Integer integer) {

    }

    @Override
    public void processError(String s, QBChatException e, QBChatMessage qbChatMessage, Integer integer) {

    }
}