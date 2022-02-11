package com.mobile.myHealth

import com.mobile.myHealth.databinding.ItemMessageReceiveBinding
import com.mobile.myHealth.databinding.ItemMessageSendBinding
import com.mobile.myHealth.model.Message
import com.xwray.groupie.databinding.BindableItem


class SendMessageItem(private val message: Message) : BindableItem<ItemMessageSendBinding>() {
    override fun getLayout(): Int {
        return R.layout.item_message_send
    }

    override fun bind(viewBinding: ItemMessageSendBinding, position: Int) {
        viewBinding.message = message
    }
}

class ReceiveMessageItem(private val message: Message) : BindableItem<ItemMessageReceiveBinding>() {
    override fun getLayout(): Int {
        return R.layout.item_message_receive
    }

    override fun bind(viewBinding: ItemMessageReceiveBinding, position: Int) {
        viewBinding.message = message
    }
}