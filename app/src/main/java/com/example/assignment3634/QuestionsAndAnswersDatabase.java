package com.example.assignment3634;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class QuestionsAndAnswersDatabase {


    public static Questions getQuestionsById (int questionID){
        return questions.get(questionID);
    }

    public static ArrayList<Questions> getAllQuestions() {
        return new ArrayList<Questions>((List) Arrays.asList(questions.values().toArray()));
    }

    public static Questions getAnswer1 (String answer1){
        return questions.get(answer1);
    }



    private static final HashMap<Integer, Questions> questions = new HashMap<>();

    static {
        questions.put(1, new Questions(
                1,
                "",
                "Jamie went to the zoo to see his favourite animals. He has been looking forward to see the koalas as he has never seen them before. However, for the duration of his stay at the zoo the koalas were all a sleep." +

                        "How does Jamie feel after his zoo trip?",
                "Sad",
                "Depressed",
                "Confused",
                "Angery",
                1
        ));

        questions.put(2, new Questions(
                2,
                "",
                "Johnson just moved half way across Australia because his parents got promoted he is just about to start his first day of Year 8. He had a lot of friends back home, however he is quite the social butterfly when he is in the mood. He loves this town  he has moved to as he has visited this town prior."+

                        "What do you think Johnson is feeling on his first day of school?",
                "Excited",
                "Nervous",
                "Moody",
                "Broody",
                2

        ));

        questions.put(3, new Questions(
                3,
                "",
                "Kimberly graduated from university 2 years ago with an information systems degree however, she has been struggling to find work ever since and has been working short term temporary jobs. "
                         +"How do you think Kimberly feels about her situation?",
                "Elated",
                "Happy",
                "Excited",
                "Cheerful",
                4
        ));

        questions.put(4, new Questions(
                4,
                "",
                "Jack is part of the tae kwon do demonstration team, and has been part of the team for over a year now. He has been working hard to learn how to do a back flip. It has been a month since he has attempted to do a backflip.  " +
                        "How was Jack feeling before he attempted to do his last back flip for the training session? ",
                "Hopeful",
                "Keen",
                "Dreamy",
                "Obssessed",
                2
        ));

        questions.put(5, new Questions(
                5,

                "",
                "Sarah woke up ready to take on her final university exam ever! She woke up early, did some yoga, had a good hearty breakfast, and left her house early. However, on her way to Randwick racecourse the 891 bus she was on broke down right outside Sydney Boys High School. " +
                        "What do you think Sarah is feeling when bus driver announced the break down? ",
                "Panicked",
                "Anxious",
                "Overwhelmed",
                "Stressed",
                1
        ));

        questions.put(6, new Questions(
                6,

                "",
                "Antonio was working on an assignment that he had due at the end of the week. Despite having received the assignment brief at the beginning of the term, he forgot about it until the week before." +
                        "How do you think Antonio is feeling now that he is under extreme pressure to finish? ",
                "Frustrated",
                "Irritable",
                "Jittery",
                "Restless",
                4
        ));

        questions.put(7, new Questions(
                7,

                "",
                "Tracy is about to leave her home for the airport when she realises she has not checked in to her flight yet. She knows there is going to be traffic and needs to leave now." +
                        "How do you think this predicament is making Tracy feel? ",
                "Distressed",
                "Flustered",
                "Hyper",
                "Fearful",
                2
        ));

        questions.put(8, new Questions(
                8,

                "",
                "Daniel has been at university working late on an final project due. Since he stayed till 4am without telling his parents they had a few words to say to him the next morning." +
                        "How do you think think his parents were feeling the night before? ",
                "Concerned",
                "Careful",
                "Surprised",
                "Disgusted",
                1
        ));

        questions.put(9, new Questions(
                9,

                "",
                "Rico recently got into a bike accident and damaged his bicycle badly. He was hoping to fix it however after several attempts he gave up." +
                        "What was Rico emotions after these attempts at fixing his bicycle?",
                "Unsatisfied",
                "Empathetic",
                "Infuriated",
                "Troubled",
                3
        ));

        questions.put(10, new Questions(
                10,

                "",
                "On the way out of Coles, Sally saw an elderly woman walking with several shopping bags. She gave her a helping hand and carried them to her car." +
                        "How do you think the elderly woman felt?",
                "Warm",
                "Shy",
                "Serene",
                "Appreciative",
                4
        ));

        questions.put(11, new Questions(
                11,

                "",
                "On the train, the guards were checking train passes. Harry was travelling with a concession Opal however did not have his student ID card." +
                        "What was Harry's emotional reaction when they approached him?",
                "Scared",
                "Worried",
                "Melancholy",
                "Bitter",
                1
        ));

        questions.put(12, new Questions(
                12,

                "",
                "Jeremy was waiting at the opening of Matcha Matcha a new bubble tea store for hours. " +
                        "How do you think he felt when he was told the store had sold out of bubble tea?",
                "Cranky",
                "Sullen",
                "Disappointed",
                "Tense",
                3
        ));

        questions.put(13, new Questions(
                13,

                "",
                "It was the first time in a while that Roger went for a run and he was not used to the Summer heatwave that was rolling through Sydney." +
                        "What were his emotions when he got back home from the run?",
                "Tired",
                "Exhausted",
                "Energised",
                "Lazy",
                2
        ));

        questions.put(14, new Questions(
                14,

                "",
                "William was walking towards the bus stop when he realised the bus had arrived earlier than expected. He ran but the bus left without him." +
                        "How do you think William felt about missing the bus?",
                "Irritated",
                "Testy",
                "Devastated",
                "Outraged",
                4
        ));

        questions.put(15, new Questions(
                15,

                "",
                "Paula just arrived at the airport to pick up her friend who had just gotten back from exchange. She had been waiting for 30 minutes when she saw her friend." +
                        "What was Paula feeling when she saw her friend walking through the Arrival Gates?",
                "Ecstatic",
                "Content",
                "Satisfied",
                "Gratified",
                1
        ));



    } //this curly bracket is for static


} // this is the curly bracket for public class first one
