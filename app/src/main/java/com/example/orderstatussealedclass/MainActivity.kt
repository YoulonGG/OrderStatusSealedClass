package com.example.orderstatussealedclass

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.orderstatussealedclass.ui.theme.OrderStatusSealedClassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        fun checkStatus(status: OrderStatus): String {
            return when(status) {
                OrderStatus.Cancelled -> OrderStatus.Cancelled.status.also {
                    Log.e("", OrderStatus.Cancelled.status)
                }
                OrderStatus.Delivered -> {
                    OrderStatus.Delivered.status.also {
                        Log.e("","Order Status : ${OrderStatus.Delivered}")
                        Log.e("","Delivering...")
                        Thread.sleep(5000)
                        Log.e("", OrderStatus.Delivered.status)
                    }
                }
                OrderStatus.Pending -> OrderStatus.Pending.status.also {
                    Log.e("","Order Status : ${OrderStatus.Pending}")
                    Log.e("", "Shipping...")
                    Thread.sleep(5000)
                    Log.e("", OrderStatus.Shipped.status)
                    Log.e("", "Delivering...")
                    Thread.sleep(5000)
                    Log.e("", OrderStatus.Delivered.status)
                }
                OrderStatus.Shipped -> OrderStatus.Shipped.status.also {
                    Log.e("","Order Status : ${OrderStatus.Shipped}")
                    Log.e("", "Shipping...")
                    Thread.sleep(5000)
                    Log.e("",OrderStatus.Shipped.status)
                    Log.e("", "Delivering...")
                    Thread.sleep(5000)
                    Log.e("", OrderStatus.Delivered.status)
                }
            }
        }
        checkStatus(OrderStatus.Shipped)
//        Log.e("", status)


    }
}
sealed class OrderStatus(val status: String) {
    data object Pending : OrderStatus("Order is pending.")
    data object Shipped : OrderStatus("Order is shipped")
    data object Delivered : OrderStatus("Order is Delivered.")
    data object Cancelled : OrderStatus("Order has been cancelled.")
}