package ru.afpf.letaem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {

    private Properties properties;

    public Bot() {
        this.properties =  new Properties();

        try {
            File file = new File("Bot.properties");
            if (!file.exists())
                throw new RuntimeException("No file with name:" + file.getName());
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onUpdateReceived(Update update) {
        try{
            Message message = update.getMessage();

//            if (message != null && message.hasText()) {
//                switch (message.getText()) {
//                    case "/start":
//                        sendMsg(message, "поехали");
//                        System.out.println(message.getText());
//                        break;
//                }
//            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendMess(long chat_id, String text){
        SendMessage sendMess = new SendMessage().setChatId(chat_id).setText(text);
        try {
            execute(sendMess);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

//    public void sendMsg(Message message, String text) {
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.enableMarkdown(true);
//
//        sendMessage.setChatId(message.getChatId().toString());
//        //sendMessage.setReplyToMessageId(message.getMessageId());
//        sendMessage.setText(text);
//        try {
//            execute(sendMessage);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }



    public String getBotUsername() {
        return properties.getProperty("BOT_NAME");
    }

    public String getBotToken() {
        return properties.getProperty("BOT_TOKEN");
    }

}
