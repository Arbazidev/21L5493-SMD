package com.example.arbaz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.Locale;

public class questions extends AppCompatActivity {

    private TextView timerTextView;
    private TextView questionTextView;
    private RadioGroup optionsGroup;
    private RadioButton option1, option2, option3, option4;
    private Button prevButton, nextButton, seeAnswerButton;
    private int currentQuestion = 0;

    // Array of marketing and business strategy questions
    private String[] questions = {
            "Q1: What is the 4Ps of Marketing?",
            "Q2: What does SWOT analysis stand for?",
            "Q3: Which of the following is a type of market segmentation?",
            "Q4: What is a 'USP' in marketing?",
            "Q5: What is a 'B2B' business?",
            "Q6: What is meant by 'Market Penetration'?",
            "Q7: Which of the following is an example of Direct Marketing?",
            "Q8: What does 'CRM' stand for?",
            "Q9: What is the main goal of branding?",
            "Q10: What does the term 'Lead Generation' mean?",
            "Q11: What is the difference between 'Product' and 'Service'?",
            "Q12: What does ROI stand for in business?",
            "Q13: Which strategy focuses on selling new products to existing customers?",
            "Q14: What is a 'Value Proposition'?",
            "Q15: What does the 'AIDA' model stand for in marketing?",
            "Q16: What is the key objective of 'Price Skimming'?",
            "Q17: What is the purpose of a business model?",
            "Q18: Which of the following best defines 'Digital Marketing'?",
            "Q19: What is 'Viral Marketing'?",
            "Q20: What is a 'Competitive Advantage'?",
            "Q21: What is the purpose of the 'Marketing Mix'?",
            "Q22: Which of the following is an example of 'Inbound Marketing'?",
            "Q23: What is the primary focus of 'Customer Retention' strategies?",
            "Q24: What does 'Franchising' involve?",
            "Q25: What is 'Content Marketing'?"
    };

    // Array of options corresponding to each question
    private String[][] options = {
            {"Product, Price, Place, Promotion", "Price, People, Process, Promotion", "Product, People, Process, Price", "People, Product, Place, Process"},
            {"Strengths, Weaknesses, Opportunities, Threats", "Sales, Work, Operations, Teams", "Strategy, Workforce, Opportunities, Trends", "Sales, Weaknesses, Options, Teams"},
            {"Demographic", "Geographic", "Behavioral", "All of the above"},
            {"Unique Selling Proposition", "Universal Sales Process", "User Sales Proposition", "Ultimate Selling Product"},
            {"Business to Business", "Business to Customer", "Business to Government", "Business to Society"},
            {"Increasing sales of existing products in existing markets", "Introducing new products to new markets", "Selling more to existing customers", "Reducing the market size"},
            {"Email Marketing", "TV Commercials", "Billboards", "Word of Mouth"},
            {"Customer Relationship Management", "Customer Retention Management", "Client Relationship Mapping", "Customer Resolution Management"},
            {"To build customer loyalty", "To increase product variety", "To decrease competition", "To improve supply chain efficiency"},
            {"Attracting and converting potential customers", "Managing existing customers", "Managing customer complaints", "Tracking customer interactions"},
            {"A product is tangible, a service is intangible", "A service has higher value than a product", "A service is more reliable than a product", "A product is customizable, a service is not"},
            {"Return on Investment", "Rate of Income", "Risk of Investment", "Revenue over Income"},
            {"Product Development", "Market Development", "Diversification", "Market Penetration"},
            {"A statement that explains why a customer should buy a product", "The financial value of a product", "The legal ownership of a product", "A list of product features"},
            {"Attention, Interest, Desire, Action", "Awareness, Interest, Decision, Action", "Attraction, Interaction, Decision, Action", "Awareness, Information, Desire, Action"},
            {"Maximizing profit by starting with high prices", "Maximizing market share with low prices", "Attracting customers with value-added services", "Building long-term customer loyalty"},
            {"To define how a company creates and delivers value", "To define a company's legal structure", "To define how a company invests", "To define a company's growth targets"},
            {"Using the internet and online platforms for marketing", "Television advertising", "Radio advertising", "Print marketing through newspapers"},
            {"A strategy to spread a message rapidly through word-of-mouth", "A strategy involving heavy social media advertisement", "A direct selling approach", "A type of cold-calling marketing"},
            {"A condition that allows a company to outperform competitors", "A company’s market share", "The amount of advertising a company does", "A company’s branding efforts"},
            {"To develop a clear plan for communicating value", "To develop a plan for market expansion", "To create a diversified product line", "To reduce operating costs"},
            {"Blogging", "TV Commercials", "Telemarketing", "Direct Mail"},
            {"To retain existing customers and reduce churn", "To acquire new customers", "To sell new products", "To launch new campaigns"},
            {"Allowing another entity to use your business model and brand", "Acquiring another company", "Selling your business", "Opening new branches directly"},
            {"A strategy focused on creating valuable content to attract customers", "Direct selling to customers", "Building partnerships with other companies", "Pricing strategies aimed at premium customers"}
    };

    // Array of correct answers corresponding to each question
    private String[] correctAnswers = {
            "Product, Price, Place, Promotion",
            "Strengths, Weaknesses, Opportunities, Threats",
            "All of the above",
            "Unique Selling Proposition",
            "Business to Business",
            "Increasing sales of existing products in existing markets",
            "Email Marketing",
            "Customer Relationship Management",
            "To build customer loyalty",
            "Attracting and converting potential customers",
            "A product is tangible, a service is intangible",
            "Return on Investment",
            "Product Development",
            "A statement that explains why a customer should buy a product",
            "Attention, Interest, Desire, Action",
            "Maximizing profit by starting with high prices",
            "To define how a company creates and delivers value",
            "Using the internet and online platforms for marketing",
            "A strategy to spread a message rapidly through word-of-mouth",
            "A condition that allows a company to outperform competitors",
            "To develop a clear plan for communicating value",
            "Blogging",
            "To retain existing customers and reduce churn",
            "Allowing another entity to use your business model and brand",
            "A strategy focused on creating valuable content to attract customers"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        // Initialize UI components
        timerTextView = findViewById(R.id.timerText);
        questionTextView = findViewById(R.id.questionText);
        optionsGroup = findViewById(R.id.optionsGroup);
        option1 = findViewById(R.id.optionA);
        option2 = findViewById(R.id.optionB);
        option3 = findViewById(R.id.optionC);
        option4 = findViewById(R.id.optionD);
        prevButton = findViewById(R.id.buttonPrevious);
        nextButton = findViewById(R.id.buttonNext);
        seeAnswerButton = findViewById(R.id.buttonRevealAnswer);

        // Load the first question
        loadQuestion();

        // Set up previous and next button listeners
        prevButton.setOnClickListener(v -> showPreviousQuestion());
        nextButton.setOnClickListener(v -> showNextQuestion());

        // Set up timer for the quiz
        startTimer();

        // Set up "See Answer" button functionality
        seeAnswerButton.setOnClickListener(v -> checkAnswer());
    }

    private void loadQuestion() {
        questionTextView.setText(questions[currentQuestion]);
        option1.setText(options[currentQuestion][0]);
        option2.setText(options[currentQuestion][1]);
        option3.setText(options[currentQuestion][2]);
        option4.setText(options[currentQuestion][3]);

        // Clear previous selection
        optionsGroup.clearCheck();
    }

    private void showNextQuestion() {
        if (currentQuestion < questions.length - 1) {
            currentQuestion++;
            loadQuestion();
        }
    }

    private void showPreviousQuestion() {
        if (currentQuestion > 0) {
            currentQuestion--;
            loadQuestion();
        }
    }

    private void startTimer() {
        new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.format("Time: %02d:%02d", millisUntilFinished / 1000 / 60, millisUntilFinished / 1000 % 60));
            }

            public void onFinish() {
                timerTextView.setText("Time's up!");
                // Disable buttons when the time is up
                nextButton.setEnabled(false);
                prevButton.setEnabled(false);
                seeAnswerButton.setEnabled(false);
            }
        }.start();
    }

    private void checkAnswer() {
        int selectedId = optionsGroup.getCheckedRadioButtonId();
        RadioButton selectedOption = findViewById(selectedId);
        if (selectedOption != null && selectedOption.getText().equals(correctAnswers[currentQuestion])) {
            // Correct answer
            selectedOption.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        } else if (selectedOption != null) {
            // Wrong answer
            selectedOption.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
 }
}
}