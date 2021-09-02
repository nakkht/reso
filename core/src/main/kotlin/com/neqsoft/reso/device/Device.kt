package com.neqsoft.reso.device

import java.util.*
import kotlin.math.abs

class Device {

    companion object {
        const val PROPERTY_COUNT = 4
        private val aspectRatios = arrayOf("9:16", "16:9", "5:9", "3:5", "40:71", "5:8", "1:1", "4:3", "2:3", "5:3", "8:5", "19.5:9", "18:9")
        private val aspectRatioValues = floatArrayOf(0.5625f, 1.7777f, 0.5555f, 0.6f, 0.5633f, 0.625f, 1f, 1.3333f, 0.6666f, 1.6666f, 1.6f, 2.1666f, 2f)
    }

    var name: String? = null
    var screenWidth = 0
    var screenHeight = 0
    var density = 0
    var aspectRatio = 0f

    val formattedScreenResolution: String
        get() = String.format(Locale.getDefault(), "%dx%d", screenWidth, screenHeight)

    val formattedDensity: String
        get() = String.format(Locale.getDefault(), "%ddpi", density)

    val formattedAspectRatio: String
        get() {
            if (aspectRatio == 0.0f) return "-"
            var lowestDiffPosition = -1
            var lowestDiff = Float.MAX_VALUE
            for (x in aspectRatioValues.indices) {
                val diff = abs(aspectRatioValues[x] - 1 / aspectRatio)
                if (diff >= lowestDiff) continue
                lowestDiff = diff
                lowestDiffPosition = x
            }
            return aspectRatios[lowestDiffPosition]
        }
}