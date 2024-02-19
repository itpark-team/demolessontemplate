package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBotHandler extends TelegramLongPollingBot {

    String botUsername = "";
    String botToken = "";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() == true) {
            Message messageFromUser = update.getMessage();

            if (messageFromUser.hasText() == true) {
                String textFromMessage = messageFromUser.getText();
                long chatId = messageFromUser.getChatId();

                SendMessage messageToUser = new SendMessage();
                messageToUser.setChatId(chatId);
                messageToUser.setText("я получил: " + textFromMessage);

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
