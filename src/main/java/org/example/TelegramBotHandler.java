package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public class TelegramBotHandler extends TelegramLongPollingBot {

    private String botUsername = "";
    private String botToken = "";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() == true) {
            Message messageFromUser = update.getMessage();

            if (messageFromUser.hasText() == true) {
                String textFromUser = messageFromUser.getText();
                long chatId = messageFromUser.getChatId();

                String textToUser = "";

                SendMessage messageToUser = new SendMessage();
                messageToUser.setChatId(chatId);
                messageToUser.setText(textToUser);

                try {
                    execute(messageToUser);
                } catch (TelegramApiException e) {

                }
            }
        }
    }


    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
