package com.my.awsapp.config

import com.my.awsapp.bot.Bot
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@Configuration
class TgConfig {
    @Bean
    @Throws(TelegramApiException::class)
    fun telegramBotsApi(): TelegramBotsApi {
        return TelegramBotsApi(DefaultBotSession::class.java)
    }
}

@Service
class Manager {

    @PostConstruct
    fun postConstruct() {
        start()
    }


    @Throws(TelegramApiException::class)
    fun start() {
        val bot = Bot("7285241827:AAFMOx9ghufuuesGF8pzrPGmLoTG-DFsxJU")
        val botsApi = TelegramBotsApi(DefaultBotSession::class.java)
        try {
            botsApi.registerBot(bot)
            println("Зарегистрирован бот ")
        } catch (e: TelegramApiException) {
            println("Не зарегистрирован бот " + e.message)
        }
    }
}