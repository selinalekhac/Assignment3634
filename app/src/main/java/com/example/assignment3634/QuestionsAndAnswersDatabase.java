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
                1

        ));

        questions.put(3, new Questions(
                3,
                "",
                "Kimberly graduated from university 2 years ago with an information systems degree however, she has been struggling to find work ever since and has been working short term temporary jobs. "+
                        "                                                     " +"How do you think Kimberly feels after the phone call?",
                "Elated",
                "Happy",
                "Excited",
                "Cheerful",
                1
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
                1
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

    } //this curly bracket is for static


} // this is the curly bracket for public class first one
