package com.example.myapplicationivan

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.*
import androidx.activity.ComponentActivity
import java.util.Calendar

class MainActivity : ComponentActivity() {

    private lateinit var editName: EditText
    private lateinit var spinnerCity: Spinner
    private lateinit var buttonStart: Button
    private lateinit var buttonClear: Button
    private lateinit var checkBox: CheckBox
    private lateinit var radioGroup: RadioGroup
    private lateinit var seekBar: SeekBar
    private lateinit var switchMode: Switch
    private lateinit var datePicker: DatePicker
    private lateinit var timePicker: TimePicker
    private lateinit var autoCompleteCity: AutoCompleteTextView
    private lateinit var progressBar: ProgressBar
    private lateinit var seekValue: TextView
    private lateinit var resultText: TextView

    private var selectedCity = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        editName = findViewById(R.id.editName)
        spinnerCity = findViewById(R.id.spinnerCity)
        buttonStart = findViewById(R.id.buttonStart)
        buttonClear = findViewById(R.id.buttonClear)
        checkBox = findViewById(R.id.checkBox)
        radioGroup = findViewById(R.id.radioGroup)
        seekBar = findViewById(R.id.seekBar)
        switchMode = findViewById(R.id.switchMode)
        datePicker = findViewById(R.id.datePicker)
        timePicker = findViewById(R.id.timePicker)
        autoCompleteCity = findViewById(R.id.autoCompleteCity)
        progressBar = findViewById(R.id.progressBar)
        seekValue = findViewById(R.id.seekValue)
        resultText = findViewById(R.id.resultText)

        val cities = arrayOf(
            "Київ",
            "Львів",
            "Одеса",
            "Харків",
            "Дніпро",
            "Запоріжжя"
        )

        val spinnerAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            cities
        )

        spinnerAdapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spinnerCity.adapter = spinnerAdapter

        spinnerCity.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    selectedCity = cities[position]
                }

                override fun onNothingSelected(
                    parent: AdapterView<*>?
                ) {
                }
            }

        val autoAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            cities
        )

        autoCompleteCity.setAdapter(autoAdapter)

        checkBox.setOnCheckedChangeListener { _, checked ->

            if (checked) {
                Toast.makeText(
                    this,
                    "Умови прийнято",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        radioGroup.setOnCheckedChangeListener { _, checkedId ->

            when (checkedId) {

                R.id.radioMale -> {
                    Toast.makeText(
                        this,
                        "Обрано: Чоловіча",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                R.id.radioFemale -> {
                    Toast.makeText(
                        this,
                        "Обрано: Жіноча",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    seekValue.text = "Значення: $progress"
                }

                override fun onStartTrackingTouch(
                    seekBar: SeekBar?
                ) {
                }

                override fun onStopTrackingTouch(
                    seekBar: SeekBar?
                ) {
                }
            }
        )

        switchMode.setOnCheckedChangeListener { _, checked ->

            val text =
                if (checked) "Режим увімкнено"
                else "Режим вимкнено"

            Toast.makeText(
                this,
                text,
                Toast.LENGTH_SHORT
            ).show()
        }

        val calendar = Calendar.getInstance()

        datePicker.init(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ) { _, year, month, day ->

            Toast.makeText(
                this,
                "Дата: $day.${month + 1}.$year",
                Toast.LENGTH_SHORT
            ).show()
        }

        timePicker.setIs24HourView(true)

        timePicker.setOnTimeChangedListener { _, hour, minute ->

            Toast.makeText(
                this,
                String.format(
                    "%02d:%02d",
                    hour,
                    minute
                ),
                Toast.LENGTH_SHORT
            ).show()
        }

        buttonStart.setOnClickListener {

            val name = editName.text.toString().trim()

            if (name.isEmpty()) {

                editName.error = "Введіть ім'я"
                return@setOnClickListener
            }

            val gender = when {

                radioGroup.checkedRadioButtonId == R.id.radioMale ->
                    "Чоловіча"

                radioGroup.checkedRadioButtonId == R.id.radioFemale ->
                    "Жіноча"

                else ->
                    "Не вибрано"
            }

            val agreement =
                if (checkBox.isChecked) "Так"
                else "Ні"

            val mode =
                if (switchMode.isChecked) "Ввімкнено"
                else "Вимкнено"

            val value = seekBar.progress

            val day = datePicker.dayOfMonth
            val month = datePicker.month + 1
            val year = datePicker.year

            val hour = timePicker.hour
            val minute = timePicker.minute

            val autoCity =
                autoCompleteCity.text.toString()

            val result = """
                
                Ім'я: $name
                Місто: $selectedCity
                Автодоповнення: $autoCity
                Стать: $gender
                Згода: $agreement
                SeekBar: $value
                Режим: $mode
                Дата: $day.$month.$year
                Час: ${String.format("%02d:%02d", hour, minute)}
                
            """.trimIndent()

            resultText.text = result

            progressBar.progress = 0

            Thread {

                for (i in 0..100) {

                    Handler(Looper.getMainLooper()).post {
                        progressBar.progress = i
                    }

                    Thread.sleep(20)
                }

            }.start()

            Toast.makeText(
                this,
                "Дані оброблено",
                Toast.LENGTH_SHORT
            ).show()
        }

        buttonClear.setOnClickListener {

            editName.setText("")
            autoCompleteCity.setText("")

            checkBox.isChecked = false

            radioGroup.clearCheck()

            seekBar.progress = 50

            switchMode.isChecked = false

            progressBar.progress = 0

            resultText.text =
                "Результат буде показано тут"
        }
    }
}