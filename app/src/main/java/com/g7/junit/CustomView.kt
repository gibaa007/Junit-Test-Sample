package com.g7.junit

import android.widget.LinearLayout
import android.widget.TextView
import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.view.LayoutInflater
import android.view.Gravity
import com.g7.junit.CustomView
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView




class CustomView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    LinearLayout(context, attrs) {

    private val mValue: View
    private val mImage: ImageView

    init {

        val a = context.obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0)
        val titleText = a.getString(R.styleable.CustomView_titleText)
        val valueColor = a.getColor(
            R.styleable.CustomView_valueColor,
            resources.getColor(android.R.color.holo_blue_light)
        )
        a.recycle()

        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL

        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.custom_view, this, true)

        val title = getChildAt(0) as TextView
        title.setText(titleText)

        mValue = getChildAt(1)
        mValue.setBackgroundColor(valueColor)

        mImage = getChildAt(2) as ImageView
    }



    fun setValueColor(color: Int) {
        mValue.setBackgroundColor(color)
    }

    fun setImageVisible(visible: Boolean) {
        mImage.setVisibility(if (visible) View.VISIBLE else View.GONE)
    }

}