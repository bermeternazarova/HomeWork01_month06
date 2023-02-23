package com.example.homework01_month06.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class TextContract:ActivityResultContract<CharSequence,CharSequence?>() {
    override fun createIntent(context: Context, input: CharSequence): Intent {
        return Intent(context,MainActivity2::class.java)
            .putExtra("key",input)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): CharSequence? {
        if (intent==null) return null
        if (resultCode!=Activity.RESULT_OK)return null

        return intent.getCharSequenceExtra("key")
    }

    override fun getSynchronousResult(
        context: Context,
        input: CharSequence
    ): SynchronousResult<CharSequence?>? {
        return null
    }
}