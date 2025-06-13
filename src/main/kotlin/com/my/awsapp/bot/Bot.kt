package com.my.awsapp.bot

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

class Bot(val token: String) : TelegramLongPollingBot(token) {

    override fun getBotUsername(): String = token

    override fun onUpdateReceived(update: Update) {
        try {
            val msg = update.message.text ?: "empty"
            println("Bot received " + msg)
            execute(
                SendMessage.builder()
                    .chatId(update.message.chatId)
                    .text("Получено сообщение - \n" + msg)
                    .build()
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}