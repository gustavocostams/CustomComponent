package com.example.customcomponent

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.customcomponent.databinding.CustomComponentAddItemBinding

@SuppressLint("CustomViewStyleable")
class CustomComponentAddItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyle, defStyleRes) {

    private val binding: CustomComponentAddItemBinding


    init {
        binding = CustomComponentAddItemBinding.inflate(LayoutInflater.from(context), this)

        LayoutInflater.from(context)
            .inflate(R.layout.custom_component_add_item, this, true)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.custom_component_attributes, 0, 0
            )
            val title = resources.getText(
                typedArray
                    .getResourceId(
                        R.styleable
                            .custom_component_attributes_custom_component_title,
                        R.string.item_one
                    )
            )

            binding.tvTitle.text = title
            binding.etItemName.hint =
                "${resources.getString(R.string.item_description)} $title"

            typedArray.recycle()
        }
    }
}