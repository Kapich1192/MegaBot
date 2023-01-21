package com.MegaBot.service;

import com.MegaBot.config.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

@Component
public class TelBot extends TelegramLongPollingBot {

    Answer answer = new Answer();
    final BotConfig botConfig;
    public  TelBot(BotConfig config) throws IOException {
        this.botConfig = config;
    }
    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chartId = update.getMessage().getChatId();

            if (messageText.contains("add honor")) {
                answer.addPromoHonor(messageText);
                sendMessage(chartId,"Промики на Хонор добавлены!");
            } else if (messageText.contains("add apple")) {
                answer.addPromoApple(messageText);
                sendMessage(chartId,"Промики на Apple добавлены!");
            } else if (messageText.contains("add samsung")) {
                answer.addPromoSamsung(messageText);
                sendMessage(chartId,"Промики на Samsung добавлены!");
            } else if (messageText.contains("add realme")) {
                answer.addPromoRealme(messageText);
                sendMessage(chartId,"Промики на Realme добавлены!");
            } else if (messageText.contains("add xiaomi")) {
                answer.addPromoXiaomi(messageText);
                sendMessage(chartId,"Промики на Xiaomi добавлены!");
            } else if (messageText.contains("add tecno")) {
                answer.addPromoTecno(messageText);
                sendMessage(chartId,"Промики на Tecno добавлены!");
            } else if (messageText.contains("add vivo")) {
                answer.addPromoVivo(messageText);
                sendMessage(chartId,"Промики на Vivo добавлены!");
            } else if (messageText.contains("add poco")) {
                answer.addPromoPoco(messageText);
                sendMessage(chartId,"Промики на Poco добавлены!");
            } else {

                switch (messageText) {
                    case "/start":
                        try {
                            startCommandReceived(chartId, update.getMessage().getChat().getFirstName());
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    //  1. realme
                    case "realme":
                        sendMessage(chartId, answer.nextPromo("realme"));
                        break;
                    //  2. apple
                    case "apple":
                        sendMessage(chartId, answer.nextPromo("apple"));
                        break;
                    //  3. samsung
                    case "samsung":
                        sendMessage(chartId, answer.nextPromo("samsung"));
                        break;
                    //  4. xiaomi
                    case "xiaomi":
                        sendMessage(chartId, answer.nextPromo("xiaomi"));
                        break;
                    //  6. honor
                    case "honor":
                        sendMessage(chartId, answer.nextPromo("honor"));
                        break;
                    //  7. vivo
                    case "vivo":
                        sendMessage(chartId, answer.nextPromo("vivo"));
                        break;
                    //  8. poco
                    case "poco":
                        sendMessage(chartId, answer.nextPromo("poco"));
                        break;
                    //  9. tecno
                    case "tecno":
                        sendMessage(chartId, answer.nextPromo("tecno"));
                        break;
                    //  10. refresh
                    case "refresh":
                        answer.refreshPromo();
                        sendMessage(chartId, "Обновление списка промокодов!!!");
                        break;
                    //  11. count
                    case "count":
                        sendMessage(chartId, answer.getCount());
                        break;
                    //  12. Info
                    case "info":
                        String info = "Основные команды для Бота: \n" +
                                "   1. realme - высылает промик на realme;\n" +
                                "   2. apple - высылает промик на apple;\n" +
                                "   3. samsung - высылает промик на samsung;\n" +
                                "   4. xiaomi - высылает промик на xiaomi;\n" +
                                "   5. honor - высылает промик на xiaomi;\n" +
                                "   6. vivo - высылает промик на xiaomi;\n" +
                                "   7. poco - высылает промик на xiaomi;\n" +
                                "   8. add realme XXXXXXXXXX - добавляет промокод в стек realme;\n" +
                                "   9. add apple XXXXXXXXXX - добавляет промокод в стек apple;\n" +
                                "   10. add samsung XXXXXXXXXX - добавляет промокод в стек samsung;\n" +
                                "   11. add xiaomi XXXXXXXXXX - добавляет промокод в стек xiaomi;\n" +
                                "   12. add honor XXXXXXXXXX - добавляет промокод в стек honor;\n" +
                                "   13. add vivo XXXXXXXXXX - добавляет промокод в стек vivo;\n" +
                                "   14. add poco XXXXXXXXXX - добавляет промокод в стек poco;\n" +
                                "   15. refresh - обновляет списки промокодов;\n " +
                                "   16. count - выводит остатки промокодов;\n ";
                        sendMessage(chartId, info);
                        break;

                }
            }
        }
    }

    private void startCommandReceived(long chartId, String name) throws TelegramApiException{

        String answer = "Hi Black Bro! Its " + name;
        sendMessage(chartId,answer);
    }

    private void sendMessage(long chartId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chartId));
        message.setText(textToSend);

        try {
            execute(message);
        } catch (TelegramApiException e){
            System.out.println("Jopa");
        }
    }
}
