package com.example.android.myproject.grammar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.myproject.R;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;

public class grammarActivity extends AppCompatActivity {


    private ListView grammarList;

    private ArrayList<the_grammar_class> arrayListGrammar;

    private ArrayAdapter<the_grammar_class> arrayAdapterGrammar;

    // use this edit text for the filter.
    // private EditText AbbreviationFilter;
    private MaterialSearchBar grammarFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities_main_layout);
        // this code   setDisplayHomeAsUpEnabled(true); will show  the back arrow in the action bar
        // now you need to go to the manifest and new attribute android:parentActivityName=" the page we want to back to "

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // to be used in the filter.
        grammarFilter = (MaterialSearchBar) findViewById(R.id.main_search);

        grammarList = (ListView) findViewById(R.id.main_listView);

        arrayListGrammar = new ArrayList<>();


        //  grammar 1
        the_grammar_class c1 = new the_grammar_class("Adjectives & Prepositions", "Some adjectives go with certain prepositions. There is no real pattern – you need to learn them as you meet them. Here are some examples but remember that there are many other adjective + preposition combinations that are not covered here.\n" +
                "\n" +
                "With ‘at’\n" +
                "I’m quite good at English but I’m bad at maths and I’m terrible at physics.\n" +
                "\n" +
                "With ‘for’\n" +
                "Jogging is good for your health but smoking is bad for you.\n" +
                "\n" +
                "The town is famous for its cheese.\n" +
                "\n" +
                "As well as ‘good for’, ‘bad for’ and ‘famous for’ we also say ‘qualified for’ ‘ready for’, ‘responsible for’, ‘suitable for’ and several others.\n" +
                "\n" +
                "With ‘of’\n" +
                "I’m perfectly capable of doing it myself, thank you.\n" +
                "\n" +
                "I’m very fond of this old sweatshirt.\n" +
                "\n" +
                "As well as ‘capable of’ and ‘fond of’ we also say ‘aware of’, ‘full of’, ‘tired of’ and several others.\n" +
                "\n" +
                "With ‘with’\n" +
                "We’re very pleased with your progress.\n" +
                "\n" +
                "You’re not still angry with me are you?\n" +
                "\n" +
                "As well as ‘pleased with’ and ‘angry with’ we also say ‘bored with’, ‘delighted with’, ‘satisfied with’ and several others.\n" +
                "\n" +
                "With ‘to’\n" +
                "She’s the one who’s married to a doctor, isn’t she?\n" +
                "\n" +
                "You’ll be responsible to the head of the Finance department.\n" +
                "\n" +
                "Notice that you can be responsible for something but responsible to someone.\n" +
                "\n" +
                "Other common adjective + preposition combinations include ‘interested in’ and ‘keen on’. It’s a good idea to make a note of new combinations in your vocabulary notebook as you meet them. Remember too that a preposition is followed by a noun or a gerund (‘ing’ form).");


        //  grammar 2

        the_grammar_class c2 = new the_grammar_class("Adjectives ending in -ed and –ing", "-ed and –ing adjectives\n" +
                "Adjectives that end ‘-ed’ (e.g. ‘bored’, ‘interested’) and adjectives that end ‘-ing’ (e.g. ‘boring’, ‘interesting’) are often confused.\n" +
                "\n" +
                "-ed adjectives\n" +
                "\n" +
                "Adjectives that end ‘-ed’ describe emotions – they tell us how people feel about something.\n" +
                "\n" +
                "I was very bored in the maths lesson. I almost fell asleep.\n" +
                "He was surprised to see Helen. She’d told him she was going to Australia.\n" +
                "Feeling tired and depressed, he went to bed.\n" +
                "-ing adjectives\n" +
                "\n" +
                "Adjectives that end ‘-ing’ describe the thing that causes the emotion – a boring lesson makes you feel bored.\n" +
                "\n" +
                "Have you seen that film? It’s absolutely terrifying.\n" +
                "I could listen to him for hours. He’s one of the most interesting people I’ve ever met.\n" +
                "I can’t eat this! It’s disgusting! What is it?\n" +
                "Remember that people can be boring but only if they make other people feel bored.\n" +
                "\n" +
                "He talks about the weather for hours. He’s so boring.\n" +
                "NOT I was very boring at the party so I went home.\n" +
                "Here are some more adjectives that can have both an ‘-ed’ and an ‘-ing’ form\n" +
                "\n" +
                "amused\n" +
                "amusing\n" +
                "annoyed\n" +
                "annoying\n" +
                "confused\n" +
                "confusing\n" +
                "disappointed\n" +
                "disappointing\n" +
                "excited\n" +
                "exciting\n" +
                "exhausted\n" +
                "exhausting\n" +
                "frightened\n" +
                "frightening\n" +
                "satisfied\n" +
                "satisfying\n" +
                "shocked\n" +
                "shocking ");

        //  grammar 3


        the_grammar_class c3 = new the_grammar_class("Articles 1", "There are lots of rules about the use of articles. Here we’ll concentrate on 3 golden rules. Most mistakes with articles are made through breaking one of these rules.\n" +
                "\n" +
                "1. When we say what people’s jobs are, we use a/an\n" +
                "\n" +
                "She’s an architect.\n" +
                "He’s a doctor.\n" +
                "My grandfather was a teacher.\n" +
                "2. Singular, countable nouns always have an article – a/an or the – or another determiner (my, your, this, that etc.)\n" +
                "\n" +
                "Remember that we use the indefinite article - a/an - when we talk about something that is not definite.\n" +
                "\n" +
                "I saw a good film yesterday. The listener doesn’t know which film.\n" +
                "There’s a man at the door. We don’t know who the man is.\n" +
                "Do you want a drink? It’s not a particular drink.\n" +
                "… and we use the definite article - the – when we talk about something more certain.\n" +
                "\n" +
                "I’m going to take the dog for a walk. The dog is a pet – it’s not just any dog.\n" +
                "Have you seen the car key? Speaker and listener know which car. It’s not just any car.\n" +
                "They live in the house opposite ours. There’s only one house opposite. It’s not any house.\n" +
                "3.  When we talk about things in general we usually use a plural noun or an uncountable noun with no article.\n" +
                "\n" +
                "Birds eat worms. NOT The birds eat the worms.\n" +
                "Water flows downhill.\n" +
                "Kangaroos live in Australia.\n" +
                "BUT We went to the zoo and saw the kangaroos. These are particular kangaroos – not kangaroos in general.\n" +
                "\n" +
                "There are many other rules about articles but remembering these 3 golden rules will reduce the number of mistakes you make.");


        //  grammar 4

        the_grammar_class c4 = new the_grammar_class("Articles 2", "In Articles 1 we looked at the 3 golden rules of articles:\n" +
                "\n" +
                "People’s jobs have a/an. He’s an architect.\n" +
                "Singular countable nouns have an article. That’s the woman I met last week.\n" +
                "Things in general – no article. Cats like mice.\n" +
                "\n" +
                "Here we look at some other rules for the use of articles.\n" +
                "\n" +
                "Special places\n" +
                "\n" +
                "My son’s at university but my daughter still goes to school.\n" +
                "He was sent to prison for 10 years.\n" +
                "Now that winter’s here I find it difficult to get out of bed.\n" +
                "I go to work by bus but I go home on foot.\n" +
                "In expressions with a number of places there is no article after a preposition.\n" +
                "\n" +
                "These places include: to/at school, to/at university/college, to/in church, to/in/out of prison, to/in hospital, to/in/out of bed, to/at work, at home.\n" +
                "\n" +
                "NOTE: While we say ‘go to school’ and ‘go to work’ etc, the expression ‘go home’ has neither ‘the’ nor ‘to’.\n" +
                "\n" +
                "Transport\n" +
                "\n" +
                "I go to work by bus but I go home on foot.\n" +
                "I hate travelling by train.\n" +
                "Modes of transport (by bus, by train, by car, by plane, by bicycle) don’t have an article. Notice that on foot is different.\n" +
                "\n" +
                "Geography\n" +
                "\n" +
                "No article – continents (Africa, Asia etc.) countries (France, Germany, Slovakia etc - but the Slovak Republic, the United States, the United Kingdom) towns & cities (Bratislava, London etc.) lakes (Lake Victoria, Lake Balaton etc.) universities (Oxford University, Nitra University etc.)\n" +
                "\n" +
                "With ‘the’ – seas & oceans (the Atlantic, the Mediterranean etc.) mountain ranges (the Himalayas, the Tatras) rivers (the Amazon, the Danube etc.)\n" +
                "\n" +
                "Other expressions\n" +
                "\n" +
                "I don’t watch television very often but I listen to the radio all the time.\n" +
                "I’ve got a headache.\n" +
                "I’ve got a stomach-ache\n" +
                "I’ve got a cold.\n" +
                "BUT\n" +
                "\n" +
                "I’ve got ‘flu.\n" +
                "I’ve got earache.\n" +
                "I’ve got toothache.\n" +
                "");


        //  grammar 5

        the_grammar_class c5 = new the_grammar_class("Countable & Uncountable nouns 1", "Countable & Uncountable nouns (1)\n" +
                "Nouns can be countable or uncountable. When you learn a new noun you should make a note of whether it is countable or uncountable as we use different words with countables and uncountables.\n" +
                "\n" +
                "Countable nouns\n" +
                "\n" +
                "There is a cat in the garden.\n" +
                "There are some birds in the trees.\n" +
                "For positive sentences we can use a/an or some (with a plural verb form)\n" +
                "\n" +
                "There isn’t a dog in the garden.\n" +
                "There aren’t any birds in the tree.\n" +
                "For negatives we can use a/an or any (with a plural verb form).\n" +
                "\n" +
                "Is there an orange on the tree?\n" +
                "Are there any chairs in the garden?\n" +
                "How many chairs are there?\n" +
                "In questions we use a/an, any or how many.\n" +
                "\n" +
                "Uncountable nouns\n" +
                "\n" +
                "There is some milk on the floor.\n" +
                "Uncountable nouns have no plural. The verb form is singular and we use some.\n" +
                "\n" +
                "Is there any sugar?\n" +
                "How much wine is there?\n" +
                "In questions we can use any or how much.\n" +
                "\n" +
                "Other expressions of quantity\n" +
                "\n" +
                "There are a lot of apples on the trees.\n" +
                "There is a lot of snow on the road.\n" +
                "A lot of can be used with both countable and uncountable nouns.\n" +
                "\n" +
                "Bill Gates has much money.\n" +
                "Notice that we don’t usually use ‘much’ or ‘many’ in positive sentences. We use ‘a lot of’.\n" +
                "\n" +
                "Bill Gates has a lot of money.\n" +
                "There’s a lot of beer but there isn’t much wine.\n" +
                "There are a lot of carrots but there aren’t many potatoes.\n" +
                "We use not many with countable nouns and not much with uncountable nouns.\n" +
                "\n" +
                "Some nouns can be both countable and uncountable, depending on how they are used, and some nouns are commonly confused. These are covered in another section. ");

        //  grammar 6

        the_grammar_class c6 = new the_grammar_class("Countable & Uncountable nouns 2", "Countable & Uncountable nouns (2)\n" +
                "Some words can be both countable and uncountable depending on how they are used.\n" +
                "\n" +
                "Would you like a chocolate?\n" +
                "Would you like some chocolate?\n" +
                "In a box of chocolates, the chocolates are countable and you can take one.\n" +
                "When you have a bar of chocolate the chocolate is uncountable and you can take some.\n" +
                "\n" +
                "There are several other nouns that can be both countable and uncountable.\n" +
                "\n" +
                "Can I have a glass of water, please?\n" +
                "There’s some broken glass on the pavement.\n" +
                "‘Glass’ is one. Many foodstuffs can be countable or uncountable. Think about the difference between ‘an ice cream’ and ‘some ice cream’ and ‘a coffee’ and ‘some coffee’\n" +
                "\n" +
                "‘few/a few’ and ‘little/a little’\n" +
                "\n" +
                "We use few and a few with countable nouns and we use little and a little with uncountable nouns.\n" +
                "\n" +
                "A few friends are coming round for dinner tonight.\n" +
                "We’ve got a little time before our train leaves. Shall we go to a museum?\n" +
                "A few and a little both mean ‘some’. They have a positive meaning.\n" +
                "\n" +
                "I’ve got very few friends here. I feel really lonely.\n" +
                "We’ve got very little time – hurry up or we’ll miss the train.\n" +
                "Few and little both mean ‘almost none’. They have a negative meaning.\n" +
                "\n" +
                "Commonly confused words\n" +
                "\n" +
                "I’d like an information about train times please\n" +
                "I’d like some information about train times please.\n" +
                "Although ‘information’ is countable in many languages, it is uncountable in English.\n" +
                "\n" +
                "Have you had any news from Pete?\n" +
                "I haven’t brought much luggage with me.\n" +
                "Can you give me some advice please?\n" +
                "As well as information, the following words are all uncountable: news, luggage, advice, furniture, weather, travel.");

        //  grammar 7

        the_grammar_class c7 = new the_grammar_class("Past Continuous and Past Simple", "1.  The most common use of the past continuous tense is to talk about something that was happening around a particular time in the past.\n" +
                "\n" +
                "What were you doing at 8 o’clock last night? I was watching television.\n" +
                "\n" +
                "I started watching television before 8 o’clock and I continued watching it after 8 o’clock.\n" +
                "\n" +
                "In 1994 he was working in a small town in Poland.\n" +
                "\n" +
                "At 6 o’clock on Saturday morning we were travelling to the airport.\n" +
                "\n" +
                "2. We often use the past continuous and the past simple tense together. When this happens, the past continuous describes a longer, ‘background’ action or situation and the past simple describes the action or events.\n" +
                "\n" +
                "When I woke up this morning it was raining and my father was singing in the kitchen.\n" +
                "\n" +
                "I was walking home, whistling happily, when I saw two masked men run out of the bank.\n" +
                "\n" +
                "Often, the ‘action’ described by the past simple tense interrupts the ‘situation’ described by the past continuous tense.\n" +
                "\n" +
                "I broke my leg when I was skiing.\n" +
                "\n" +
                "I was playing a computer game when the doorbell rang.\n" +
                "\n" +
                "Notice that the past continuous describes ‘situations’ that go on for some time – ‘skiing’ and ‘playing’ but the past simple describes ‘actions’ that happen quickly – ‘broke’ and ‘rang’.\n" +
                "\n" +
                "Notice too the important difference between these two sentences.\n" +
                "\n" +
                "When they arrived, Jeff was cooking dinner. Jeff started cooking before they arrived.\n" +
                "\n" +
                "When they arrived, Jeff cooked dinner. Jeff started cooking dinner after they arrived.");

        //  grammar 8

        the_grammar_class c8 = new the_grammar_class("Question forms & subject/object questions", "Question forms & subject/object questions\n" +
                "Review of question forms\n" +
                "\n" +
                "Yes/No questions\n" +
                "\n" +
                "Is he a teacher? Yes he is.\n" +
                "Can you swim? No, I can’t.\n" +
                "Have they got a car? Yes they have.\n" +
                "To form yes/no questions where there is an auxiliary verb or a modal verb, we invert the word order of a positive sentence. (He is a teacher > Is he a teacher?)\n" +
                "\n" +
                "Do you eat fish? No I don’t.\n" +
                "Does she know you. Yes she does.\n" +
                "When there is no auxiliary verb we use ‘do’ to form the question.\n" +
                "\n" +
                "With question words\n" +
                "\n" +
                "The same rules apply when there is a question word (‘what’, ‘where’, ‘when’, ‘why’, ‘who’, ‘which’, ‘how’, ‘how much’, ‘how many’)\n" +
                "\n" +
                "Where is the hotel?\n" +
                "What can you smell?\n" +
                "Who has just arrived?\n" +
                "Where there is an auxiliary or modal verb, that verb is used to form the question.\n" +
                "\n" +
                "How did you get here?\n" +
                "When do your parents get back?\n" +
                "How much does it cost?\n" +
                "Where there is no auxiliary verb, we use do.\n" +
                "\n" +
                "Subject/Object questions\n" +
                "\n" +
                "Sometimes you might see questions like this.\n" +
                "\n" +
                "Who broke the window?\n" +
                "What happened next?\n" +
                "Who told you that?\n" +
                "There is no auxiliary verb and the word order is not inverted.\n" +
                "\n" +
                "These are called subject questions – because the question word is the subject of the sentence.\n" +
                "\n" +
                "Look at these two questions.\n" +
                "\n" +
                "Who does Romeo love? Romeo loves Juliet.\n" +
                "Who loves Romeo? Juliet loves Romeo.\n" +
                "In the first question, Romeo is the subject of the verb.\n" +
                "In the second question ‘who’ is the subject and Romeo is the object.");

        //  grammar 9

        the_grammar_class c9 = new the_grammar_class("Verbs followed by ‘ing’ or by ‘to + infinitive’ 1", "When one verb is followed by another, the second verb can either be an\n" +
                "\n" +
                "infinitive\n" +
                "\n" +
                "or an\n" +
                "\n" +
                "–ing\n" +
                "\n" +
                "form. Some verbs can be followed by only an\n" +
                "\n" +
                "infinitive\n" +
                "\n" +
                ", others by only an\n" +
                "\n" +
                "–ing\n" +
                "\n" +
                "form and some by both but with a change in meaning. To know which structure to use, you can consult a good dictionary but here are some common examples.\n" +
                "\n" +
                " \n" +
                "\n" +
                "\n" +
                "Verb + infinitive\n" +
                "\n" +
                "I want to speak to the manager.\n" +
                "She’s learning to ride a horse.\n" +
                "He offered to help us wash up.\n" +
                "‘Want’, ’learn’ and ‘offer’ are followed by to + infinitive\n" +
                "\n" +
                "Other verbs in this group include: afford, agree, ask, choose, decide, expect, hope, prepare, promise, pretend, refuse, would like.\n" +
                "\n" +
                "Verb + ‘ing’ form\n" +
                "\n" +
                "I enjoy travelling.\n" +
                "He admitted stealing the necklace.\n" +
                "I don’t mind waiting if you’re busy.\n" +
                "‘enjoy’ ‘admit’ and ‘mind’ are followed by the ‘ing’ form\n" +
                "\n" +
                "Other verbs in this group include: avoid, consider, dislike, feel like, finish, give up, can’t help, practise, suggest.\n" +
                "\n" +
                "Verb + infinitive or ‘ing’ form with no change in meaning\n" +
                "\n" +
                "A few verbs can be followed by either an infinitive or the ‘ing’ form and the meaning does not change.\n" +
                "\n" +
                "I started to work here in 1994.\n" +
                "I started working here in 1994.\n" +
                "The meaning of these two sentences is the same.\n" +
                "\n" +
                "There aren’t many verbs that can take an infinitive or an ‘ing’ form with no change in meaning. ‘Begin’ and ‘continue’ are two more examples.\n" +
                "\n" +
                "There is also a group of verbs that can be followed by an infinitive or an ‘ing’ form with a change in meaning. These verbs will be covered in another section.");


        arrayListGrammar.add(c1);
        arrayListGrammar.add(c2);
        arrayListGrammar.add(c3);
        arrayListGrammar.add(c4);
        arrayListGrammar.add(c5);
        arrayListGrammar.add(c6);
        arrayListGrammar.add(c7);
        arrayListGrammar.add(c8);
        arrayListGrammar.add(c9);


        arrayAdapterGrammar = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayListGrammar);


        grammarList.setAdapter(arrayAdapterGrammar);


        grammarList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                the_grammar_class tem = arrayListGrammar.get(position);
                //  also make sure to add it here .
                String theGrammarName = tem.getThe_grammar_name();
                String theGrammarText = tem.getThe_grammar_text();


                // will use this to send the data to the MistakesHolder.
                Bundle bundle = new Bundle();
                bundle.putString("theGrammarName", theGrammarName);
                bundle.putString("theGrammarText", theGrammarText);

                // send the bundles using intnent , use put extras .

                Intent intent = new Intent(grammarActivity.this, grammarHolder.class);
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });


        // add text changer listener ,the filter process take place here :

        // giving the Search some features "

        grammarFilter.setHint("Search");
        grammarFilter.setCardViewElevation(10);
        grammarFilter.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // reference the context of this page
                (grammarActivity.this).arrayAdapterGrammar.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }//  end of onCreate


    // this code allows the and setup the up navigation from activity to the fragment i came from

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public class the_grammar_class {

        private String the_grammar_name;
        private String the_grammar_text;


        public the_grammar_class(String the_grammar_name, String the_grammar_text) {
            this.the_grammar_name = the_grammar_name;
            this.the_grammar_text = the_grammar_text;
        }


        public String getThe_grammar_name() {
            return the_grammar_name;
        }

        public void setThe_grammar_name(String the_grammar_name) {
            this.the_grammar_name = the_grammar_name;
        }

        public String getThe_grammar_text() {
            return the_grammar_text;
        }

        public void setThe_grammar_text(String the_grammar_text) {
            this.the_grammar_text = the_grammar_text;
        }

        // this method will display only the word in the list .
        @Override
        public String toString() {
            return the_grammar_name;
        }


    }// end of  the_story_class


}//  end of grammarActivity


