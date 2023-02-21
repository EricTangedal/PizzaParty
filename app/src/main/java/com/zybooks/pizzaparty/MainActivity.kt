/****************************************************
 * AUTHOR: Eric A Tangedal
 * COURSE: CS 134: Mobile App Development (Kotlin)
 * SECTION: 1351 Online
 * LAB #: Lab 1
 * TITLE: PizzaParty
 * LAST MODIFIED: 2/20/2023
 ****************************************************/
// Package name
package com.zybooks.pizzaparty

// Imported libraries
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil
/**
 * Declares and initializes a constant for the amount of slices per pizza.
 * @param SLICES_PER_PIZZA stores the standard amount of slices per pizza.
 * @return 8
 */
const val SLICES_PER_PIZZA = 8
/**
 * This class is used to calculate the total number of pizzas needed for a pizza party,
 * based off the number of people attending, how hungry they are, and how many slices per pizza.
 * It creates a user interface with text boxes and radio buttons.
 * @return totalPizzas
 */
class MainActivity : AppCompatActivity() {
    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup
    /**
     * Creates and display layout and content using resources.
     * @param numAttendEditText an editable text box.
     * @param numPizzasTextView an uneditable text box.
     * @param howHungryRadioGroup a group of radio buttons.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)
    }
    /**
     * Calculates and displays totalPizzas when the "Calculate" button is clicked
     * using numAttend, slicesPerPerson, and SLICES_PER_PIZZA.
     * @param numAttendStr get text from numAttendEditText.
     * @param numAttend convert and store int value of numAttendStr
     * @param slicesPerPerson get int value from how hungry radio button selection.
     * @param totalPizzas calculates total pizzas needed for party.
     * @return totalPizzas in numPizzasTextView
     */
    fun calculateClick(view : View) {
        val numAttendStr = numAttendEditText.text.toString()
        val numAttend = numAttendStr.toInt()
        val slicesPerPerson = when (howHungryRadioGroup.checkedRadioButtonId) {
            R.id.light_radio_button -> 2
            R.id.medium_radio_button -> 3
            else -> 4
        }
        val totalPizzas = ceil(numAttend * slicesPerPerson / SLICES_PER_PIZZA.toDouble()).toInt()
        numPizzasTextView.text = getString(R.string.newTotalPizzas, totalPizzas)
    }
}