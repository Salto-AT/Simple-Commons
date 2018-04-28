package com.simplemobiletools.commons.activities

import android.os.Bundle
import android.view.LayoutInflater
import com.simplemobiletools.commons.R
import com.simplemobiletools.commons.extensions.*
import com.simplemobiletools.commons.helpers.*
import com.simplemobiletools.commons.models.License
import kotlinx.android.synthetic.main.activity_license.*
import kotlinx.android.synthetic.main.license_faq_item.view.*
import java.util.*

class LicenseActivity : BaseSimpleActivity() {
    override fun getAppIconIDs() = intent.getIntegerArrayListExtra(APP_ICON_IDS) ?: ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_license)

        val linkColor = getAdjustedPrimaryColor()
        val textColor = baseConfig.textColor
        updateTextColors(licenses_holder)

        val inflater = LayoutInflater.from(this)
        val licenses = initLicenses()
        val licenseMask = intent.getIntExtra(APP_LICENSES, 0) or LICENSE_KOTLIN
        licenses.filter { licenseMask and it.id != 0 }.forEach {
            val license = it
            inflater.inflate(R.layout.license_faq_item, null).apply {
                license_faq_title.apply {
                    text = getString(license.titleId)
                    underlineText()
                    setTextColor(linkColor)
                    setOnClickListener {
                        launchViewIntent(license.urlId)
                    }
                }

                license_faq_text.text = getString(license.textId)
                license_faq_text.setTextColor(textColor)
                licenses_holder.addView(this)
            }
        }
    }

    private fun initLicenses() = arrayOf(
            License(LICENSE_KOTLIN, R.string.kotlin_title, R.string.kotlin_text, R.string.kotlin_url),
            License(LICENSE_SUBSAMPLING, R.string.subsampling_title, R.string.subsampling_text, R.string.subsampling_url),
            License(LICENSE_GLIDE, R.string.glide_title, R.string.glide_text, R.string.glide_url),
            License(LICENSE_CROPPER, R.string.cropper_title, R.string.cropper_text, R.string.cropper_url),
            License(LICENSE_MULTISELECT, R.string.multiselect_title, R.string.multiselect_text, R.string.multiselect_url),
            License(LICENSE_RTL, R.string.rtl_viewpager_title, R.string.rtl_viewpager_text, R.string.rtl_viewpager_url),
            License(LICENSE_JODA, R.string.joda_title, R.string.joda_text, R.string.joda_url),
            License(LICENSE_STETHO, R.string.stetho_title, R.string.stetho_text, R.string.stetho_url),
            License(LICENSE_OTTO, R.string.otto_title, R.string.otto_text, R.string.otto_url),
            License(LICENSE_PHOTOVIEW, R.string.photoview_title, R.string.photoview_text, R.string.photoview_url),
            License(LICENSE_PICASSO, R.string.picasso_title, R.string.picasso_text, R.string.picasso_url),
            License(LICENSE_PATTERN, R.string.pattern_title, R.string.pattern_text, R.string.pattern_url),
            License(LICENSE_REPRINT, R.string.reprint_title, R.string.reprint_text, R.string.reprint_url),
            License(LICENSE_GIF_DRAWABLE, R.string.gif_drawable_title, R.string.gif_drawable_text, R.string.gif_drawable_url),
            License(LICENSE_AUTOFITTEXTVIEW, R.string.autofittextview_title, R.string.autofittextview_text, R.string.autofittextview_url),
            License(LICENSE_ROBOLECTRIC, R.string.robolectric_title, R.string.robolectric_text, R.string.robolectric_url),
            License(LICENSE_ESPRESSO, R.string.espresso_title, R.string.espresso_text, R.string.espresso_url),
            License(LICENSE_GSON, R.string.gson_title, R.string.gson_text, R.string.gson_url),
            License(LICENSE_LEAK_CANARY, R.string.leak_canary_title, R.string.leakcanary_text, R.string.leakcanary_url),
            License(LICENSE_NUMBER_PICKER, R.string.number_picker_title, R.string.number_picker_text, R.string.number_picker_url)
    )
}
