package com.kcdeepak.imeautofill

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

class InputView(context: Context, attributeSet: AttributeSet) : FrameLayout(context,attributeSet) {
    var realHeight:Int=0

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        realHeight = measuredHeight
        if(EXPAND_TO_WINDOW && MeasureSpec.getMode(heightMeasureSpec)==MeasureSpec.AT_MOST){
            setMeasuredDimension(measuredWidth,MeasureSpec.getSize(heightMeasureSpec))
        }
    }
    fun getTopInsets():Int{
        return measuredHeight-realHeight
    }

    companion object{
        private const val EXPAND_TO_WINDOW:Boolean = false
    }
}