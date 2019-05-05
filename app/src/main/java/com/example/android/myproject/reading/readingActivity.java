package com.example.android.myproject.reading;

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

public class readingActivity extends AppCompatActivity {

    private ListView readingList;

    private ArrayList<the_story_class> arrayList_reading;

    private ArrayAdapter<the_story_class> arrayAdapterReading;

    // things done here work on readingHolder and make the xml layout

    // use this edit text for the filter.
    // private EditText AbbreviationFilter;
    private MaterialSearchBar readingFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities_main_layout);
        // this code   setDisplayHomeAsUpEnabled(true); will show  the back arrow in the action bar
        // now you need to go to the manifest and new attribute android:parentActivityName=" the page we want to back to "

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        readingList = (ListView) findViewById(R.id.main_listView);

        // to be used in the filter.
        readingFilter = (MaterialSearchBar) findViewById(R.id.main_search);

        arrayList_reading = new ArrayList<>();


        //  this is story 1
        the_story_class c1 = new the_story_class("Tape It", "Eggs, bacon, bagels, and croissants, her favourite meal of the day sat right in front of her alluring her to have more, some more, a bigger portion, probably just this one day. Her hand reached out for the last croissant; “STOP” said her mind, “PLEASE” begged the nineteen year old heart. She could feel the tires around her waist, weighing her down, emotionally and physically. She pulled her arm back, eyeing the lush croissant, which would have been hers, only if she had not decided to follow her dream, a dream so far fetched, which seemed nearly impossible.\n" +
                "\n" +
                "But there she was, she wanted it, and wanted it bad, a fantasy of a teenager to fit into the beautiful peacock green bikini. A trip had been planned, to the city of beaches, by her huge group of friends, and the trip included her. She used to sit dejected listening to her slim friends discuss about the kind of clothes they have purchased, and how short each of their skirts were, and how beautiful they looked. She wanted to be among them discussing her size, and see their expression change from surprise to admiration; and so she decided.\n" +
                "\n" +
                "Up and down, back and forth, her life jolted by vigorous gym sessions, her scale; her worst nightmare smiled at her happily, as it moved away from the bigger numbers, bit by bit, slow but steady. She was overjoyed, she felt it, from within, as she stood in front of the mirror, analysing her reflection, measuring her inches. Click opened her wardrobe, and proudly hung the bikini, but it wasn’t time. She removed it admiringly, stroked the fabric, and visualized herself on the shore of a beach, flaunting her curves, bikini clad.\n" +
                "\n" +
                "Her thoughts were interrupted by the knock at her bedroom door. She heard her mother scream out for her, it was time for supper, and back she was with her bowl of assorted vegetables and her best entertainer, the television. She zapped, ate, zapped, reaching for the last lettuce leaf in her bowl, only realising her stomach craved for something extra. It frustrated her that she could feast on her favourite fried chicken, mashed potatoes, Oreo biscuits or additional helpings of Hazelnut Choco spread. She had been through this a dozen times, but this time it was different, she wanted to be someone else, someone popular, and someone that made heads turn. She had to compromise, and so she did, with a little reluctance once in a while, but a whole new chapter of determination. She wanted to be the topic of harmless gossip among the ones in school; she wanted to be out dating on Saturdays, partying on Sundays, shopping in skimpy outfits, which she had dreaded to wear till now.\n" +
                "\n" +
                "Weeks passed, her patience started to die away, she once in a while treated herself with an ice cream, the fat was stubborn and refused to melt fast, but the time did. No matter how less she ate, she still looked awfully plump, which annoyed her and she was ready to call it quits. She sat on her fluffy bed and wept an entire evening, ignoring her dinner. Her tears dried up, leaving her cheeks cold, she lay down on her bed staring at the ceiling, letting random thoughts pass by her mind.\n" +
                "\n" +
                "She hadn’t realised but her bedroom was hot and stuffy, she leapt out of her bed to open the windows. The wind blew into her round pale face. She stared outside her window, and watched a mother treading along the footpath along with her son. The boy would have easily been older than twelve, the woman looked very familiar; maybe she was someone from her apartment. She watched closely as the son held on to his mother’s saree and plodded along with her. His head bent, in an awkward gait, made him look a bit abnormal. She closely watched them enter the apartment; they stopped to talk to another mother, who also had a teenage son but a much normal looking one. Standing near the window on the ground floor and only a few meters away from them, she could overhear their conversations, though she had to strain her ears a little. The usual small talk, recipe exchange, and the latest saree in fashion, bored her and as she stepped away from the window, she heard one of the lady say something about a special school.\n" +
                "\n" +
                "She immediately turned towards them and observed the mother of the abnormal, waiting for her to react, in a furious way, or probably a wretched expression. On the contrary, her face blossomed and she began raving about her son’s painting skills, and his ability to play the guitar even without learning.\n" +
                "\n" +
                "The middle aged woman added, “My child is special, and every child is god’s gift. It doesn’t matter what’s on the outside, inner self is what matters.”\n" +
                "\n" +
                "Standing in her bedroom, through the window she gazed at the boy playing with a Rubik’s cube, his tongue curving as per each turn of the cube and his eyes fixed on the colourful object. She ran to her closet and saw the beautiful looking bikini sitting inside. She took one last look at it and stuffed it inside the top shelf. She looked at herself in the mirror and, her flesh noticeably bulging out from her denim, and her belly sagging down. She met her eyes’ reflection and said the words aloud, “I am a beautiful person.”\n" +
                "\n" +
                "She smiled at herself and looked around her bedroom, her space where she became what she was; where ideas, thoughts, desires and hopes were given birth to, and where she found her true self.\n" +
                "\n" +
                "__END__\n" +
                "\n");

        // this is story 2

        the_story_class c2 = new the_story_class("Heal", "I stood on the balcony, staring blankly at the crashing waves. The coffee in my hand had grown cold. I ran my fingers on my face, pushing back my wind whipped hair and brushing away my tears at the same time. My cheeks were dry. The salty breeze had dried up the salty tears. I placed the coffee cup on the floor and turned away slightly to avoid the strong winds. And that was when I saw him.\n" +
                "\n" +
                "He was silhouetted against the pink sky, tall, alone, dark and frozen. He stood there on that rock, looking straight, staring into the ocean just like I had been staring a few minutes ago.  The sky grew orange, then deep rust. The ball of fire slowly sank into the black waters. He stood there a little longer till darkness set in and slowly, head bowed low, stepped off the rock and walked away from the dark sands. My gaze followed him until he vanished behind a clump of bushes. I shut the balcony door and went back into the empty room.\n" +
                "\n" +
                "I was healing. Or atleast, I was supposed to be healing. It was peaceful now, being away from the sympathy and shared tears. My grief was mine and mine alone. I missed Adi every minute of the day, but atleast I didn’t have people telling me, telling me, what a wonderful person he was and what a shock it was to have lost him like that. Like I didn’t know.  Like I didn’t feel. These few weeks in this small seaside town was exactly what I needed. An escape from everyone who knew me. Who knew us. They were well wishers who wanted to share my sorrow, but their good intentions were slowly driving me towards insanity. I needed to get away.\n" +
                "\n" +
                "I went down for dinner. The couple who owned this homestay were in the living room. They looked up from their moment of togetherness and smiled at me. The lady got up and called out to the maid to serve me my dinner. I was a writer, on a break to write a book. That is what they thought. And that was what justified my odd behavior.\n" +
                "\n" +
                "The next morning I walked on the sand barefoot as the eastern sky grew light. I picked up shells  and then threw them back on the beach. I dug my toes into the cool sand as I walked, breathing in the fresh morning air. I went up to the rock where I saw him last night. I could not shake away that picture from last evening. That was the first time I had seen him in these two weeks, but I instinctively felt some sort of bonding with him. I sat on the rock, staring into the  sea until it became too warm to stay outside.\n" +
                "\n" +
                "I read ,wrote,  swam and took small walks in the shady gardens for the rest of the day, just as I had been doing for the past two weeks. I had not healed yet, but the isolation and the sea had soothed me.  I forced myself not to think of Adi, his smile, his hug. His love.  Those terrible days in the hospital after his accident. I also shouldn’t have survived , but I did. Why?. I suddenly missed him terribly. And I almost burst into tears again.\n" +
                "\n" +
                "That evening , I walked out to the balcony with my cup of coffee.  Twilight was my favorite part of the day. And as the sky changed colours and the clouds blushed, my eyes scanned the sands and stopped again on that rock. He was there again, standing straight, alert, staring at the waves. Waiting.\n" +
                "\n" +
                "One more week passed like this. Every evening I wanted to walk up to the beach and go closer to him, but something stopped me. I didn’t want to intrude into whatever it was that brought him there every evening. So I just stood there on my balcony with a cup of neglected coffee, watching him dissolve into the darkness every evening.\n" +
                "\n" +
                "It was my last day by the sea. I walked past the packed bags on the floor that evening and went downstairs. I smiled a small smile at the new guests who were sipping tea in the living room and walked outside. It was drizzling. I didn’t bother to pick up an umbrella. I stepped into the wind laden spray of raindrops and my feet took me across the damp sands. Towards him. I stood there, still, silent, behind him. He sensed me, but he did not turn. The waves came and went. He stared and waited. The rain grew fiercer, but both of us did not move.\n" +
                "\n" +
                "‘Scott’, a voice called from behind. I turned. A woman was approaching us, flustered and wet. She saw me standing there, behind him. With a curiously glance at me, she instinctively shared her umbrella over my head. I smiled at her and then looked at him again. He hadn’t turned or moved an inch. Her eyes saw the question in my eyes and she shook her head sadly.\n" +
                "\n" +
                "‘ I work in that house, ma’ she said, pointing to a house on the shore, beyond the bushes.\n" +
                "\n" +
                "‘ It has been a year. They were playing in the beach one evening  when she ran into the sea chasing a ball. She was just five years old, such a pretty child. Maggie. We couldn’t even find her body’.\n" +
                "\n" +
                "Tears filled the woman’s eyes.\n" +
                "\n" +
                "‘ Her parents were so angry with him that they just abandoned him here and left to their city. He now lives with the old couple in that house. They are a lonely couple, they treat him like their own son now.  But he hasn’t forgotten. He comes here every evening and waits for his little playmate to return from the ocean. Maybe he thinks she will be back someday or maybe he knows and feels guilty that he couldn’t save her’. She shook her head sadly.\n" +
                "\n" +
                "I looked at him, standing on that rock, soaked in the rain, but still unflinching in his wait. A tear rolled down my cheek. For the first time in months, it was not a tear for Adi.\n" +
                "\n" +
                "‘Scott, va’, the woman said and grabbed his collar, almost dragging him. He turned. Our eyes met. ‘ Forget , Scott.’ I whispered. ‘ Heal. They are not coming back. Your Maggie. Or my Adi.’  I bent down to touch him. He moved closer and looked at me, eyes limpid pools of sadness. And as though he understood what I had said, he let out a short bark and wagged his tail.\n" +
                "\n" +
                "__END__");


        // this is story 3


        the_story_class c3 = new the_story_class("On the Edge of the Cliff", "He stood at the edge of the cliff. All he needed was a push. A mental push.\n" +
                "\n" +
                "The water below looked blue. Crystal clear.\n" +
                "\n" +
                "He mentally calculated the distance to the rocks below. If he would have been in his swanky office complex now, he would probably have been standing on the balcony of the third floor.\n" +
                "\n" +
                "The only difference was that this was not his office and there was no balcony here.\n" +
                "\n" +
                "He reminded himself that he had quit his job sometime ago. He had a menial job slogging on his workstation for some client whose only reasons of hiring people in India were that labor and real estate were cheap. He was paid, but not much. He used his brains while working, but not much. In a nutshell, his life was like most of the white collared, educated, salaried labor class that this country specializes in producing. No, his work life was not the problem. The problem was something else. Something more profound. Something whose roots lay deeper. His life appeared pointless. His money appeared worthless. His clothes, his shoes, his watch and all his material belongings seemed pathetic. His life was not so bad a couple of months ago.\n" +
                "\n" +
                "The commute to his office was mostly uneventful. He had to endure the typical sights and sounds of the torture chamber called the “public transport in India” every morning. Every neatly ironed shirt got hopelessly crumpled within the first ten minutes of the journey. Weird smelling hair oils on random heads chocked his nostrils everyday. And the shoes. He had the habit of polishing his shoes everyday till he had started working. The commute to office changed all that.\n" +
                "\n" +
                "On normal days, the number of feet that may have left their mark on his shoes could be somewhere around ten. On some days, it went up to twenty. Hopelessly, he had given up polishing before he left for his work resorting to using the services of the poor boy near his office who worked in a makeshift arrangement where he not only mended shoes but also polished and shone them. He was a person he met daily. He had dirty hair and probably two sets of tattered clothes which he wore on alternate days. His lips were dry and his finger nails were dirty. He looked no different than any rag-picker that anyone from outside India loves to take a photograph of and show it to his wife back home. He had big brown eyes though. Those eyes were beautiful.\n" +
                "\n" +
                "Their initial interaction remained strictly business related. The boy polished his shoes and he paid him. Not a word was exchanged for the first couple of months. Gradually, their meetings got informal. It took some time but smiles were followed by occasional chit-chat. The duration of their interaction still remained limited to those five minutes per day only partly because of the fact that he had a habit of reaching his workplace right before his shift was about to start.\n" +
                "\n" +
                "Two weeks ago, for the first time, the boy had a request to make. By then, their occasional chit-chat had turned into crisp conversations with more meaningful sharing of information. At the outset, his request seemed strange. This conversation was different. It had money involved.\n" +
                "\n" +
                "The boy had requested him to lend him some money.\n" +
                "\n" +
                "He had promised to return it though. “Why do you need the money?” had had asked the boy.\n" +
                "\n" +
                "The boy had not replied but he had probably seen a tear drop at the edge of his eye waiting to gain in volume and roll down his cheek. The boy had wiped his eyes with his dirty hands before that could happen.\n" +
                "\n" +
                "“I think I have to go see the doctor.”, the boy had said.\n" +
                "\n" +
                "“I have been coughing a lot of late. There is a lot of blood. I am scared.”, the boy had said crying.\n" +
                "\n" +
                "He had stood there unmoved. He was not sure he believed the story. A lot of similar stories from a lot of urchins he had met on the roads had an almost similar, albeit slightly tweaked, theme. “Bulls**t”, he had thought to himself.\n" +
                "\n" +
                "“I shiver at night too. I have no one in this world who I can call my own. I am lonely. And scared. Please help me sir. I have no money.”, the boy had continued.\n" +
                "\n" +
                "“Yeah right! As if this was the first time I am hearing something of this sort from someone of your social standing.”, he had thought to himself.\n" +
                "\n" +
                "“Let me see what I can do for you. Don’t worry. Everything’s going to be fine. I am there for you. I will take you to the doctor tomorrow.”, he had told the boy softly caressing his hair.\n" +
                "\n" +
                "His words had seemed to calm the boy. He thought he had taken care of the matter.\n" +
                "\n" +
                "He had it all figured out. He would not break the boy’s heart right away by showing that he did not believe in his story but there was no way that he was falling into his trap and letting him get away with what he considered blatant extortion.  From the next day onwards, he had started using the second entrance to his office, the one on the other side of the building.\n" +
                "\n" +
                "He had started a practice of packing his neatly polished pair of shoes in a plastic bag and carrying them while his commute to work, which he suffered wearing a pair of sandals and then changing into his shoes before he entered his workplace. He avoided the first gate even at the end of his shift, even though he was pretty sure that the boy would not be there then, just to be sure that the boy could never see him again. He thought that he had done pretty well in his attempts at avoiding the boy.\n" +
                "\n" +
                "Today had been a different day than all the previous days though. He was just about to enter his office building through the second gate in a slight hurry since he had to change into his shoes before entering the office and he was running out of time. It was then that he saw the crowd near the first gate. It seemed odd. There appeared to be some police-men and what looked like an ambulance from the pre – independence era. He walked towards the crowd partly out of curiosity and partly because he felt a gentle force pulling him towards the scene.\n" +
                "\n" +
                "What he saw, froze the world around him. There was the boy on the ground, covered in blood. There was blood all over his tattered shirt, around his lips and on his chin. There were open wounds in his body. Blood had oozed out of them and had coagulated. He appeared skinnier than when he had last seen him two weeks ago. He looked pale and dead. He walked away, as if in a trance.\n" +
                "\n" +
                "He quit his job that afternoon and jumped from the edge of the cliff that evening.\n" +
                "\n" +
                "__END__");

        // this is story 4

        the_story_class c4 = new the_story_class("Cycle of Life", "\n" +
                "That day, old man was leaving us, forever!!!\n" +
                "\n" +
                "I heard my mother calling relatives and friends, one-by-one, on phone and telling the news in sobbing voice, “They will take out ventilator today at around 3 PM. You may come to see him before that.”A week before that day, when he was taken to hospital, my father was helping grandpa to lie on back seat of our car. I could not forget grandpa’s last unanswered reply when I, while trying to control my tears, asked my mother whether he would be all right. Grandpa called me by weak gesture and softly caressed my hair as he generally used to do. But, very soon, his hand slipped away from my head, holding left part of his chest to unsuccessfully stop the rising pain. He was struggling to breathe normally. He was the same man who once almost ran to market in heavy rain to buy inhaler for me, when I lost the one in school and was little breathless because of asthma I had. But when it came to him that day I could not do much but just cried. My mother embraced me saying grandpa would come back soon.\n" +
                "\n" +
                "A night before that day, at hospital’s reception my mother was consoling my distressed looking father to accept the destiny, “it has to happen one day.” I did not understand what it meant but simply closed my eyes and prayed God to let my grandpa be well soon. My grandpa once told me that prayers from children are pure and they surely reach God. But it did not happen, perhaps.\n" +
                "\n" +
                "That day, we reached hospital at 1 PM. We went inside. Security at reception did not stop me that day. I was following my mother trying to meet her pace, climbing stairs, to ICU where grandpa was admitted. A nurse guided us to a room. After a long week gap I saw my grandpa — my best friend. Grandpa was sleeping peacefully on hospital bed. There were many small TV and radio alike boxes with tiny lights. Few boxes were making “beep-beep” sound in rhythm. I knew that the sound was fading heart beats of my best friend — my grandpa. Then I saw my father, with red and swollen eyes, sitting closure to grandpa’s bed. My mother could not control herself. She started sobbing loudly kneeling at my father shoulder. My father gently stood up and took my crying mother out of the room.\n" +
                "\n" +
                "I was left alone with the most adorable man of my life. I went closure to him, where my father was sitting just few seconds back. I watched the face of my dear grandpa. There was no pain — it was calm and composed. Even with few plastic tubes in his nose and mouth and a white foggy gas mask on it, I found his face quite charming and graceful. I started caressing grandpa’s hair. I wished that he utter my name… just once… It was the same mouth that told me so many stories, every day, until I slept. I was waiting for his eyes to be opened… to see me last time… but he continued sleeping… these were the old eyes that never got tired enjoying watching my toys, my drawing, my homework, my mark sheets… Then I looked at his hand. It was same hand that used to caress my hair. I held his palm in my both hand. I tried measuring my palm with his. Nothing had changed. His palm was still larger than mine. I touched his index finger… I held it last time… holding it always assured me safe feeling in busy markets and crowded places…\n" +
                "\n" +
                "I took out my inhaler from my pocket and kept it on a nearby table where already many medicines were kept scattered. I remembered once my grandpa told me that the inhaler was my life saviour… I murmured in grandpa’s ear, “Don’t worry Grandpa, you would get well soon. I kept here inhaler to save you.”…\n" +
                "\n" +
                "“It’s a boy” exhilarated voice of my father brought me back in my present. Today, after eighteen years later, on the same floor of the same hospital I found my father rushing towards a nurse who was carrying a just born baby. “What are you doing there… come… look at him… he resembles ‘ditto’ your grandpa”, almost shouted my father in excessive excitement, carefully holding the baby in his arms.\n" +
                "\n" +
                "But I saw my grandpa in my father more than in my just born son. A new cycle of life has started… to repeat itself once again.\n" +
                "\n" +
                "__END__");

        // this is story 5

        the_story_class c5 = new the_story_class("The Tiger Cat", "I looked towards the cage again. I was surprised to see the animal. I had never seen such an animal in my lifetime. I looked at my friend. He was smiling blissfully. He was content.\n" +
                "\n" +
                "“How much did you buy it for?” I asked.\n" +
                "\n" +
                "“Quite a lot, my friend, quite a lot!” He said.\n" +
                "\n" +
                "I was pretty sure that the amount was quite high. Or else he wouldn’t have avoided telling me the amount.\n" +
                "\n" +
                "“But why did you buy it? I never knew you had a thing for cats. Or any animals for that matter.” I said.\n" +
                "\n" +
                "“First of all, It’s not exactly a cat. Second of all, look at it. Have you ever seen such an exquisite animal? Look at the stripes. It’s like a little tiger. A mixture of Cat and the Tiger. But I would like to think it is a tiger.”\n" +
                "\n" +
                "I glanced again towards the cage. What I saw bewildered me to no bounds. My friend was right. It wasn’t exactly a cat. I had never seen anything like it. It had yellow and black stripes just like a tiger. If it were not for its size, anybody would have said that it was a tiger. Yet, it’s size was that of a cat. It was sitting down now. And even the body movements and the sitting down posture, it looked or should I say it mimicked the tiger. It was an amazing creature. The cage was about 4 feet in length and 2.5 feet in height. I thought that the cage was a little too small for a creature like that.\n" +
                "\n" +
                "“It’s a small tiger.” My friend Ganesh exclaimed. It was evident that he was quite taken by the creature. I was not sure where he got it from.\n" +
                "\n" +
                "“Is it a Tiger Cub?” I asked. This thought had occurred to me. I have seen the Tiger cubs. But only on TV. In real life I had never seen one.\n" +
                "\n" +
                "“No, no it’s not a tiger cub. It’s a tiger cat.” He laughed.\n" +
                "\n" +
                "“A Tiger Cat!” I exclaimed. “Ganesh, where did you buy it from? And whom did you buy it from?” I asked. My tone was curious and excited.\n" +
                "\n" +
                "When Ganesh had called me earlier today and said that he wanted me to see something, an animal like this was the last thing on my mind. I could sense the excitement in Ganesh’s voice. My curiosity got the better of me. And of course I had nothing else to do. So, I got to his house as soon as possible.\n" +
                "\n" +
                "“A Chinese gentlemen from the Chinatown, he sold me this. Yesterday evening, I had gone there for a dinner party. After the dinner was over, everybody left. I was waiting for a bus to come along. That’s when I saw this beauty opposite to the bus stand. I got intrigued by it. So I went to the store. I asked the Chinese gentleman about this animal. He said it was a rare breed. It was a mixture of Tiger and cat. Believe me, it was looking amazing in that golden cage. Such beautiful movements. Such elegance in an animal. I knew I had to buy it.”\n" +
                "\n" +
                "“Are you sure, he said it is a mixture of cat and tiger. I mean, I never have even heard of such a cat. But I could be wrong.” I said.\n" +
                "\n" +
                "“It’s a Tiger cat. That’s what the Chinese gentleman told me. It brings good luck. I tried to buy it. But he wouldn’t sell it. I kept rising the price. But he wouldn’t care. He said, It is an important member of his family. But I was adamant. I said, I wouldn’t go without taking the animal.” My friend hesitated for a moment and then continued. “So in the end, he agreed to sell me this magnificent creature. But when I was taking it away, the Chinese gentleman said that, it doesn’t bring good luck to everybody. There is a hard price to it. But what is a hard price for good luck. Right? So I took it.” Ganesh was still grinning. He looked like a man who had just found a treasure of gold.\n" +
                "\n" +
                "“Have you let it out yet? I mean, has the cat or the tiger cat come out of the cage?” I enquired.\n" +
                "\n" +
                "Ganesh shook his head. His face gave a wince. “That’s just it. It refuses to come out. I opened the cage door. But it doesn’t want to get out.”\n" +
                "\n" +
                "“Perhaps, this new surrounding is upsetting him. Perhaps he is missing his old master.” I said.\n" +
                "\n" +
                "“Yes. Perhaps.” Ganesh replied.\n" +
                "\n" +
                "I had a nagging feeling that something was not right. But I guessed if my friend was happy, who was I to interfere with his life?\n" +
                "\n" +
                "I glanced at the cage. I saw the animal. Even it’s face was like a tiger. The more I looked at this amazing creature, the more I got convinced that it was more of a tiger and less of a cat. Only the size of the animal was small. In all other aspects I found the animal to be more tiger and less cat.\n" +
                "\n" +
                "“What does it eat?” I asked Ganesh.\n" +
                "\n" +
                "“That’s just it. I didn’t ask the Chinese gentleman about his eating habit. So today I got fish from the market. But he is refusing to eat it. He is just turning away his mouth. He is only drinking water for now.”\n" +
                "\n" +
                "“But cats eat fish.” I said.\n" +
                "\n" +
                "Ganesh nodded and looked at the animal, still smiling he said, “But he doesn’t. I am thinking of giving him chicken. Let’s see whether he likes it or not. But I am sure of one thing though, my luck is changing.”\n" +
                "\n" +
                "After some time, we got up. Ganesh said he was going to the market to bring food for his precious animal, while I left for my home.\n" +
                "\n" +
                "After two days, I had taken an early leave from my office. And I was very interested in my friend’s new pet. So I went to the National Library. And I checked for cats. Any type or breed of cats. Very soon I came across this breed. The Tiger Cat! I read up the material. It said, Tiger cats are direct breed of the Tiger found in Asia. However, they are mainly cats. They are very very rare to find. Not even 400 of them exist today. And most of them are found in China. I saw the attached photo of the Tiger Cat. I must say what I saw at Ganesh’s house didn’t actually match with the photo. But I was getting confirmed that what I saw was indeed a Tiger Cat.\n" +
                "\n" +
                "3 more days had passed. I was busy with my work and I had completely forgotten about Ganesh and his Tiger cat. Suddenly on the sixth day, Ganesh called. He sounded very worried and scared. It was like he was rambling on and on about his tiger cat. He said, he is going crazy with it. He was unable to go outside, because he didn’t want to let this tiger cat out of sight for one moment. And he was hooked on to it. He just couldn’t take his eyes off it. And something terrible was happening to it. I tried to calm him down and asked him what had happened. But he couldn’t say. He said, he couldn’t cal anyone and he thought about me. He had only shown this creature to me and now he wants my help. I asked him to calm down and said that I would come to his house as soon as possible. Within the next hour, I reached his house. When he opened the door, I saw my friend’s face. He looked tired, scared and highly anxious. He was sweating and it was evident he had not eaten for a long time now.\n" +
                "\n" +
                "“What happened to you?” I asked.\n" +
                "\n" +
                "“Come inside. Quickly. I have to show you something.” He said. He was shivering with fear.\n" +
                "\n" +
                "There was a slight noise, something like low growl, coming from the other room. It was in this room where he had placed the cage and the Tiger Cat. Suddenly, I felt a shiver along my spine. He grasped me and took me to the other room. I could sense his sweaty palms cold with fear. I could smell a foul smell coming. But I could not identify where this smell was coming from.\n" +
                "\n" +
                "As soon as I entered the room, what I saw sent shivers through my body. I was looking at the cage. But what I saw I could not believe. This could not have been possible. Was I seeing things? I saw a large cat or a middle sized tiger inside the cage. The cage now was completely filled by the animal’s body. It was barely able to move. I could see that It was looking at us. The eyes of this animal was green and it was filled with hatred. I was hypnotized for a moment. I could not shift my gaze. I thought I was paralyzed by fear, by the animal. I will be never be able to forget what I saw that day. My friend came close to me and whispered to my ear. His voice was hoarse. And in the hoarse voice, He whispered in to my ear, “Do you see? Do you see what has happened to my Cat. I can’t understand what happened to him. It was growing daily. I tried to feed him, but he wouldn’t eat. He would only drink water. And every day I watched him grow. I couldn’t go out. I was scared that if I went out, he would escape. And in 5 days he has grown up to this size. I don’t know how much will he grow in the coming days. Help me!!”\n" +
                "\n" +
                "He put so much stress on the last two words that he almost screamed in his whisper. I stood my ground like a lamp post. My brain was still trying to put things logically. I knew what had happened was impossible. Yet I was looking at this…creature, which had grown in size in 5 days! It was impossible.\n" +
                "\n" +
                "I breathed in deeply and with almost a herculean effort I managed to look away. I quickly managed to stagger out of the room. My friend was holding me. He came out too.\n" +
                "\n" +
                "I saw a chair and quickly sat down. I was sweating too now. This was incredible. What was I supposed to do now? I closed my eyes and breathed deeply for some time. When I opened my eyes, I thought of something.\n" +
                "\n" +
                "“Do you remember the place from where you had brought this infernal thing?” I asked. There was anger in my voice. And I did not hide it. I had told Ganesh earlier. I had warned him. But he kept insisting on keeping this creature.\n" +
                "\n" +
                "“Yes, yes I remember.” Ganesh said. His eyes looked pleading. It was as if he was begging to me to take this problem away. He had suffered enough.\n" +
                "\n" +
                "“Well. Let’s go there. And find this Chinese gentleman of yours and ask him to take back his animal.” I said in a little more commanding voice.\n" +
                "\n" +
                "“Yes. Yes you are right. Let’s go there. We need to find the man. I can’t keep this thing.” He said.\n" +
                "\n" +
                "We quickly got out of the building. Initially he was feeling a little insecure about leaving the creature alone in his apartment. But I had to convince him, that it was the only way. Since I didn’t know where he bought this animal from, he had to come with me. It took us an hour and a half to reach China town. We quickly moved with in the narrow streets and reached the place. Ganesh suddenly stopped. He looked crestfallen. He was standing infront of a shop. But the shutter was pulled down. And it was evident that the shop was closed. He frantically searched for a door or some sort of opening. But it was all in waste. I went to the adjacent shop and asked about this shop. The shop keeper couldn’t help me. He said he didn’t know where the owner had gone or when will the shop be opening. He simply couldn’t tell us anything. Ganesh was looking everywhere. He was asking everyone on the streets. But no one had any idea about the shop.\n" +
                "\n" +
                "“Perhaps there is a back entrance. Let’s go in the back to check it out.” He said.\n" +
                "\n" +
                "In my mind I knew that this will be hopeless. But I couldn’t refuse. We went across and circled the whole neighbourhood, but there was no door. There was no opening or any entrance. I looked at my friend. He looked around in dismay. He looked so distraught that I felt pity for him.\n" +
                "\n" +
                "“Ayushman!” Ganesh looked at me and said, “I have to tell you something!”\n" +
                "\n" +
                "I slowly walked to my friend. I had never seen him like this. His face was looking so much older. It was evident that he had not been sleeping properly. In fact, I was quite sure that the last few days, he had not slept at all. He looked quite thinner. As if, within a few days he had lost at least 10 kilos. This new pet of his, was causing him a lot of pain. He looked afraid. He had not eaten too. What had he become?\n" +
                "\n" +
                "“What is it?” I said. I talked quite softly.\n" +
                "\n" +
                "“Well, the Chinese gentleman, from whom I got this cat.” He stopped. He looked at both sides of the street. He looked reluctant to talk. Yet he was making an effort to say something. He was struggling with himself.\n" +
                "\n" +
                "“Tell me the problem.”\n" +
                "\n" +
                "“Well…actually he did not sell it to me.” My friend said. He did not look at my eyes.\n" +
                "\n" +
                "“What? What are you saying? Did you steal it?” I exclaimed. This statement of his did not come as a shock to me. I was kind of expecting it. I knew that something was bothering my friend. Perhaps this was it.\n" +
                "\n" +
                "“I offered the Chinese gentleman a lot of money. But he did not want to sell it. For a moment he went inside the shop. And that is when I ……” He left the sentence unfinished.\n" +
                "\n" +
                "“And that is when you stole it?” I asked. I was now holding Ganesh by his shoulders and shook him.\n" +
                "\n" +
                "“I did not steal it. I kept all the money I had on his table. I took the cage and quickly got out of the shop. The cage was heavy. As soon I got out, I got a taxi. I was lucky. I quickly got in with the cage. The cage fitted in the taxi. So it was easy. And I left.” Ganesh finished.\n" +
                "\n" +
                "“But that’s stealing Ganesh. Don’t you understand?” I shouted in anger. I was a little irritated. Anger and frustration had crept into me. Only then I realized that what kind of a predicament my friend is in now. I am only feeling his frustration. I took several deep breaths. Ganesh kept looking at me. His eyes looked ever so innocent. I understood that he only wanted to get out of this weird situation. I had to think for him. It was quite obvious that he was unable to think for himself.  I had a different idea.\n" +
                "\n" +
                "“All right. Listen. I think I have a solution. First, lets buy a bigger cage to fit the thing. Right. ….Right.”\n" +
                "\n" +
                "Ganesh nodded. At this moment he would agree to anything I say, I thought.\n" +
                "\n" +
                "“Ok. “ I continued, “Then tomorrow, we visit this shop again. If it is closed, then we hire some guys from the zoo, to take this thing in to that bigger cage and from your house to somewhere safe for both of you.”\n" +
                "\n" +
                "“What if he doesn’t stop growing?” Ganesh had tears in his eyes now. His voice was almost pleading.\n" +
                "\n" +
                "“He will stop growing.” I answered in an affirmative loud voice. But I was unsure of it myself. What if Ganesh’s right? No I couldn’t even bear to think on that line. I need to think positively.\n" +
                "\n" +
                "By evening, we had got a bigger and a stronger cage. I We took this cage to Ganesh’s Apartment. It was un-assembled. The cage had come with rivets and bolts and had to be assembled by the right people. I asked him to wait until the next morning. He followed everything what I said. ‘What an amazing transformation of a man who was so happy and confident only a week ago.” I thought.\n" +
                "\n" +
                "I left his apartment and went home. That night I couldn’t sleep. It would not be wrong to say that even I was a little worried with what I saw. How can any animal grow so large in just a few days. There must be a rational explanation to this. But unfortunately I couldn’t find one. I did not know when I slept that night. But it was a long time later.\n" +
                "\n" +
                "When I woke the next morning, the first thought that came to my mind was how was Ganesh? I decided to call him right away and ask him about the situation. The phone couldn’t connect. I got ready very quickly and quickly went to his house.\n" +
                "\n" +
                "I came up to his door and knocked for a couple of times. But there was no answer. I thought maybe he was sleeping. So I knocked quite loudly the next time. But again there was no answer from inside. My heart gave a miss. Suddenly a cold and an uneasy feeling crept unto me. ‘Was he alright?’\n" +
                "\n" +
                "I had started sweating. I knocked on the door a few more times and again there was no answer. I went to his neighbour’s door. A middle aged looking man with a moustache and light beard opened the door. It was very evident he was sleeping and I had disturbed his sleep.\n" +
                "\n" +
                "“Excuse me, I am sorry to disturb you like this so early in the morning. But did you by any chance see or hear my friend Ganesh?” I asked him.\n" +
                "\n" +
                "He looked at me. His eyes were slightly open. He was a little confused. But after a second or two, it seems he understood what I said and then he shook his head. I thanked him for his reply and let him proceed with his sleeping. He did now know anything. I looked around. There was no one there. Perhaps Ganesh had gone outside. But then why would he have gone outside? And his door was locked from the inside. He had to be inside. I thumped hard on the door this time. I didn’t care what any one would think. And I was least bothered about the noise. I kept knocking and thumping and in between calling his name. But still there was no answer. The neighbor had opened the door again. There was an irritated look to his face. I quickly explained to him that my friend was in some deep trouble. And that no one was answering his door. The sleep from his eyes vanished. He said he would call the police. Meanwhile, I decided that I wouldn’t wait for that long to wait for the police. Using all my might, I gave a mighty push to the door. It almost broke. But it couldn’t resist the second push. And as soon I entered Ganesh’s room, I saw an old man lying on the floor. My heart beating so hard, I thought it would come out. This was not right. I called loudly Ganesh’s name. But there was no answer. Slowly I moved towards that old man who lying on the floor. It looked as if he was at least 100 years old. His skin was dry and shrunken. The hair was white and gray. I looked at his hands, it was bony. As if only the dry skin was on bone. One of his hands was on his chest. His face was twisted as if he was under a lot of pain. His face looked like a skull covered by very dry skin. There was pain his expressions. I looked at his legs and it was bent in a very awkward way. As if his feet was suffering from severe cramps. The old man was dead. But who was this old man. But where was Ganesh?\n" +
                "\n" +
                "Suddenly I thought of the Animal. Where was the beast? I nervously looked around. Was it free? Has it broken free and perhaps Ganesh had run away.\n" +
                "\n" +
                "I slowly walked in to the room where Ganesh had kept the Cage along with the Tiger cat. What I saw amazed me to bounds. The golden cage was still there. And in one of the corner of the golden cage, there was a small cat, almost the size of kitten. It was resting and It was contently licking his paw. I could not believe my eyes. I searched the whole apartment, there was no one else. I knew it but I was reluctant to admit it. I slowly walked towards the old man. The dead old man was my friend Ganesh!");

        // this is story 6

        the_story_class c6 = new the_story_class("Survivor", "It had been more than 4 days. He could not believe the turn of events. A week back, he had a comfortable job working for one of the richest men in the world. Now, he was afraid he would not survive another day.\n" +
                "\n" +
                "A week back:\n" +
                "\n" +
                "The phone rang early morning:\n" +
                "\n" +
                "“David, Sophie is flying back to Paris tonight; make sure the plane is ready by 7 PM.”\n" +
                "\n" +
                "After a month of leisure at the classy hotel at Victoria Falls, David was glad to have something to do. Even if it meant flying his employer’s spoilt wife back home. He disliked her to the point of avoiding being alone with her. None of the stewardesses had come along on this trip, so he realised he would be truly alone with her on this flight. She was always rude and loud. Hopefully, she will be asleep throughout the trip, he thought.\n" +
                "\n" +
                "As he waited for Sophie in the hangar at the airport, David went over the weather charts once more. He was not happy with the clouds forming over Central Africa. But he could fly over most of them, he figured. He did not want to tell Sophie that they could not fly out today. His experience with her over the last couple of years had taught him to keep such thoughts to himself. If she did not get her way, she could make life very difficult for everyone she came in contact with.\n" +
                "\n" +
                "After a wait of about thirty minutes, he saw the company car pull up at the entrance of the hangar. He got out of the plane to escort her in. When the car door opened, he noticed that Sophie was conservatively dressed today. She held out her hand and he noticed the nails were painted a garish blue colour. He had never seen nails painted in that colour. He took her hand and escorted her to the plane and seated her. No conversation was exchanged there.\n" +
                "\n" +
                "The plane took off without incident. David would have liked to switch to auto-pilot, but the weather made him nervous. After about an hour, when he did not hear from her, he assumed she had fallen asleep. As they approached the clouds over Central Africa, he saw the weather had graduated to a thunderstorm. He pulled the aircraft up, attempting to fly over the clouds, but could not avoid them. As the clouds enveloped the aircraft, he kept it on an incline hoping to break through the clouds in a few seconds.\n" +
                "\n" +
                "That’s when the lightning bolt struck the engine.\n" +
                "\n" +
                "Six days back:\n" +
                "\n" +
                "David woke up with a start. The cold forest floor had chilled his body, making him numb. Memories of the night before came back. He again felt the panic, the terror of feeling the plane stall and drop from the sky.\n" +
                "\n" +
                "The lightning strike had roasted the controls. Nothing worked. With the plane gliding down in a slow decline, he grabbed the emergency kit and got out of the cabin to warn Sophie. When he saw her, she had the same panic and terror in her eyes that he had. He groped under her seat for her emergency kit and pulled it out. He handed her the orange lifejacket and wore his own. He put on his parachute pack and turned to her. She had not moved. David told her to wear the lifejacket one more time and then repeated it again when she did not respond.\n" +
                "\n" +
                "He grabbed her arms and forced them through the opening in the lifejacket. He did the same with the parachute pack and pulled her towards the door. He again noticed the blue fingernails. She kept fighting against him and pulling him back. He pulled harder. He opened the door which let in a blast of cold, wet wind. He felt the plane vibrate. He pulled her closer to the door and told her what he was going to do. He did not know if she heard him over the sound of the wind, but she started screaming which David interpreted as the reaction to his instructions. Without warning, he pushed her out and after a few seconds, he jumped out himself.\n" +
                "\n" +
                "He saw her tumbling through the air for a few moments after which the parachute self-deployed and shielded her from his eyes as a white canopy opened up. His own parachute deployed and took him in a different direction. By the time he turned back towards her, he could not see a thing. All he saw were the clouds and the occasional lightning bolt splitting them. Luckily, he landed on the ground in a small clearing in the forest. He landed on his feet and instantly collapsed on his back. He was so exhausted that he fell into a tired sleep right there.\n" +
                "\n" +
                "Now he was up and did not know where to start. He found some rainwater caught in the cavity formed by a large leaf which he drank. He tried to remember all the survival tactics that he was taught in flight school. He figured he was in the Central African rainforest and civilisation was a long way off in all directions. He took out the compass in his emergency kit and headed west.\n" +
                "\n" +
                "Five days back:\n" +
                "\n" +
                "David had stumbled through the jungle for the last 24 hours. He was tired and sleepy, but he wouldn’t dare go to sleep during the night. He had found a few berries in the forest which he ate reluctantly. He wanted to conserve the food packets in the emergency kit. That was not a good idea because he fell violently ill spewing all the food he had eaten in the last 24 hours on the ground. After that incident, he could not eat anything the whole day and night.\n" +
                "\n" +
                "At daybreak, he stopped under a tree. He spread the parachute canopy on the ground and collapsed on it into a deep sleep.\n" +
                "\n" +
                "Someone was poking him. His eyes shot open and he sat up. The first thing he saw was a small dark child. Then he saw there were several other children behind the first one. He tried to stand up, but fell. He heard the children laughing and realised that his hands and feet were tied. That is when he also realised they were not children at all. They were fully grown men.\n" +
                "\n" +
                "He remembered reading about a tribe of pygmies that lived deep in the Central African rainforest. They were so secluded that they had never seen a normal human. David tried, but could not remember anything else from that article.\n" +
                "\n" +
                "The men picked a thick stick and slid it between his legs and arms and four men carried him through the jungle like a captured animal. By the time, they reached their village, David’s wrists and ankles were rubbed raw against the stick, his arms were ready to pop out of their sockets and he was bleeding. They dumped him on the ground and untied his wrists and feet. David could not even raise his head to see where he was. He passed out into a painful sleep.\n" +
                "\n" +
                "Four days back:\n" +
                "\n" +
                "David woke up to find four pygmy men inspecting him. He stood up quickly, but sat down again as two of them raised a bow with a metal-head arrow pointed at him. The other two men continued inspecting him as if nothing had happened. They raised his arm and checked it. They did the same with his leg. They kept shaking their heads. After about five minutes of poking and prodding, they walked off discussing animatedly and the two armed men also moved away, but kept the arrows pointed at him till they were out of sight.\n" +
                "\n" +
                "David looked around and saw that he was placed in the centre of a shaded clearing on the ground. He was surrounded by a thick wall of thorn bushes which looked very formidable. The other side of the wall was probably safe to touch because the men went out from an opening in the wall and pushed it in to close the opening.\n" +
                "\n" +
                "After a while, two men stepped into the clearing. One had the usual bow and arrow while the other carried a wooden bowl and a stone slab. The stone slab had strips of meat on it that had recently been roasted on a fire and seasoned with something that smelled like ginger. The bowl contained a clear liquid with large chunks of meat in it. As soon as David saw the food, he realised how hungry he was. He waited for the men to place the food on the ground before him. As soon as they stepped out of the clearing, he grabbed the food. The meat strips were quite chewy, but full of flavour. The soup was also tasty though he would have preferred a little more meat in it.\n" +
                "\n" +
                "After devouring the simple meal, he lay down on the ground. He had to figure out a way to escape from these people. Sure, they had fed him and not harmed him yet, but he did not know how long this would continue.\n" +
                "\n" +
                "Today:\n" +
                "\n" +
                "For the last four days, David was as comfortable as possible. He had food thrice a day regularly. He was given his parachute canopy to sleep on and they did not touch him at all. In fact, if it were not for the armed man who came in with the food, he would have thought they are a peaceful tribe. The armed guard actually made sense when David thought about it. He would probably go through the same thing in any country where he arrived without permission. They had probably not seen a white man before and were not sure what he was.\n" +
                "\n" +
                "David was not afraid anymore. He had started talking to the man who brought him his food. He started off talking softly with a lot of smiles. Yesterday they had shook hands. He tried to find out the man’s name, but could not get through to him. But the other man smiled back and chattered away in a strange language. David also eagerly looked forward to the food. In fact, he liked the meat a lot. It was soft and chewy and the gingery flavour exploded in his mouth.\n" +
                "\n" +
                "There was nothing violent about them. In fact, he saw a few children looking at him through the bushes. He waved at them and the children ran off screaming and laughing. David decided that after a few more days, he would convince them to let him out of the makeshift prison. He would probably live there for a few weeks and then begin a trek back to civilisation. He wondered which direction he would head off to. He will have to figure out which country he was in before he started his journey. But David was not worried; he had plenty of time to think about it.\n" +
                "\n" +
                "Just then, his new friend stepped into the clearing with the same bowl and slab of rock. He placed them on the ground in front of David and smiled at him. David smiled back and waved. The man waved back and stepped out of the opening and shut it.\n" +
                "\n" +
                "David finished off the meat strips and picked up the bowl. He drank some of the liquid before picking out the meat. The first piece was slender and he turned it around. Startled, he dropped the bowl and the piece of meat and screamed.\n" +
                "\n" +
                "The blue fingernail was pointing at him accusingly.\n" +
                "\n" +
                "David couldn’t take his eyes off it. He couldn’t stop screaming…\n" +
                "\n" +
                "__END__");

        // this is story 7

        the_story_class c7 = new the_story_class("Monster under the bed", "“Mummy!! Mummy!!”\n" +
                "\n" +
                "Sudha entered the room, “What is it, honey?”\n" +
                "\n" +
                "The child was kneeling on the bed looking at her wide-eyed. She has obviously not slept for long, her big red eyes speaking of a horror that Sudha’s adult mind could never comprehend. She had not slept a wink for the last two days. The child was keeping her up all night. Shifting to a new house coupled with forced insomnia was not a good restraint for her temper.\n" +
                "\n" +
                "“There is something under my bed” the child screamed.\n" +
                "\n" +
                "Not again, Sudha thought. When she heard the child, she rolled on her bed to wake her husband, but he wasn’t there. He must have gone to the bathroom, she thought. Wearily, she got out of the bed to go to the child’s bedroom.\n" +
                "\n" +
                "“There is nothing under the bed, sweetheart, you just had a bad dream.”\n" +
                "\n" +
                "“Nooo, I know there is something there.” with the conviction that comes with being a child.\n" +
                "\n" +
                "Sudha sighed. This is going to be a long night. I am going to end this tonight, she thought.\n" +
                "\n" +
                "“Ok, if I check under the bed and find nothing, will you go back to sleep?” she asked the child.\n" +
                "\n" +
                "“Maybe…”\n" +
                "\n" +
                "“Ok, let me get the flashlight…” she said.\n" +
                "\n" +
                "She walked out of the room and called her husband. There was no answer.\n" +
                "\n" +
                "“Mummy!!”\n" +
                "\n" +
                "Sudha walked back into the room.\n" +
                "\n" +
                "“Daddy went under the bed with the flashlight…”\n" +
                "\n" +
                "“What?”\n" +
                "\n" +
                "“Daddy went under the bed with the light… it must be lying there.”\n" +
                "\n" +
                "Mildly surprised, Sudha bent down to peer under the bed. She can see something shiny under the bed. She reaches out for it and touches it, but it rolls further away. She feels something sticky on the floor. She pulls back her hand and checks it under the lamp on the bedside table. It is something dark and sticky. She looks at the child.\n" +
                "\n" +
                "“Did you drop something under the bed?”\n" +
                "\n" +
                "“A chocolate…” the child murmured in a guilt-ridden voice.\n" +
                "\n" +
                "“Where is Daddy?”\n" +
                "\n" +
                "“He is still under the bed…”\n" +
                "\n" +
                "Surprised, Sudha bent down again. The flashlight has rolled towards the other end of the bed against the wall. She crawled under the bed and reached it. Before she could turn it on, she felt something or someone grip her hand. She let out a small scream, but the grip only tightened. She shouted and thrashed, but something clutched her throat and her voice was cut off. In another five seconds, her body stopped moving.\n" +
                "\n" +
                "The child peered over the edge of the bed and saw the edge of a small dark puddle of liquid. The child smiled.\n" +
                "\n" +
                "“Are you still hungry?”\n" +
                "\n" +
                "__END__");


        arrayList_reading.add(c1);
        arrayList_reading.add(c2);
        arrayList_reading.add(c3);
        arrayList_reading.add(c4);
        arrayList_reading.add(c5);
        arrayList_reading.add(c6);
        arrayList_reading.add(c7);


        arrayAdapterReading = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList_reading);


        readingList.setAdapter(arrayAdapterReading);


        readingList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                the_story_class tem = arrayList_reading.get(position);
                //  also make sure to add it here .
                String theStoryName = tem.getThe_story_name();
                String theStoryText = tem.getThe_story_text();

                // will use this to send the data to the MistakesHolder.
                Bundle bundle = new Bundle();
                bundle.putString("theStoryName", theStoryName);
                bundle.putString("theStoryText", theStoryText);

                // send the bundles using intnent , use put extras .

                Intent intent = new Intent(readingActivity.this, readingHolder.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        // add text changer listener ,the filter process take place here :

        // giving the Search some features "

        readingFilter.setHint("Search");
        readingFilter.setCardViewElevation(10);
        readingFilter.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // reference the context of this page
                (readingActivity.this).arrayAdapterReading.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }// end of onCreate

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


    public class the_story_class {

        private String the_story_name;
        private String the_story_text;

        public the_story_class(String the_story_name, String the_story_text) {
            this.the_story_name = the_story_name;
            this.the_story_text = the_story_text;
        }

        public String getThe_story_name() {
            return the_story_name;
        }

        public void setThe_story_name(String the_story_name) {
            this.the_story_name = the_story_name;
        }

        public String getThe_story_text() {
            return the_story_text;
        }

        public void setThe_story_text(String the_story_text) {
            this.the_story_text = the_story_text;
        }

        // this method will display only the word in the list .
        @Override
        public String toString() {
            return the_story_name;
        }


    }// end of  the_story_class

}// end of readingActivity
