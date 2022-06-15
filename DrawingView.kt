package com.govind8061.kidsdrawing

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup

class DrawingView(context: Context): View(context) {
    var params: ViewGroup.LayoutParams?=null
    var path: Path=Path()
    var brush: Paint=Paint()
    init {
        brush.isAntiAlias=true
        brush.color=Color.MAGENTA
        brush.style=Paint.Style.STROKE
        brush.strokeJoin=Paint.Join.ROUND
        brush.strokeWidth=8f

        params= ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val pointX=event?.x
        val pointY=event?.y

        when(event?.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(pointX as Float, pointY as Float)
                return true
            }MotionEvent.ACTION_MOVE -> {
                path.lineTo(pointX as Float,pointY as Float)
            }else -> return false
        }
        postInvalidate()
        return false
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawPath(path,brush)
    }
}