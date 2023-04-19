import java.util.*;

public class Question {
    
    //questions 3D array which is a constant
    private final String[][][] questionSets = {
        {
            {
                "Marbury v. Madison (1803)",
                "McCulloch v. Maryland (1819)",
                "Schenck v. United States (1919)",
                "Brown v. Board of Education (1954)",
                "Baker v. Carr (1961)",
                "Engel v. Vitale (1962)",
                "Gideon v. Wainwright (1963)",
                "Tinker v. Des Moines Independent Community School District (1969)",
                "New York Times Co. v. United States (1971)",
                "Wisconsin v. Yoder (1972)"
            },
            {
                "Established the principle of judicial review empowering the Supreme Court to nullify an act of the legislative or executive branch that violates the Constitution",
                "In striking down Maryland's tax on the National Bank, the holding established supremacy of the U.S. Constitution and federal laws over state laws. Often referenced in regards to strengthening the implied powers of the federal government.",
                "Speech creating a clear and present danger to national security or public safety is not protected by the First Amendment",
                "Race-based school segregation violates the equal protection clause. Overturned Plessy v. Ferguson",
                "Decided that redistricting issues present justiciable questions, thus enabling federal courts to intervene and to decide redistricting cases. The defendants unsuccessfully argued that redistricting of legislative districts is a political question, and hence not a question that may be resolved by federal courts. One person, one vote.",
                "School sponsored prayer and bible readings violates the establishment clause because students feel compelled to participate even if they are not religious or Christian.",
                "Guaranteed the right to an attorney for the poor or indigent (and subsequently everyone) in a state felony case (Incorporation)",
                "Preemptively banning students from wearing black armbands in school to protest the Vietnam War was deemed unconstitutional",
                "Bolstered the freedom of the press, establishing a heavy presumption against prior restraint even in cases involving national security. The ruling made it possible for newspapers to publish the then-classified Pentagon Papers without risk of government censorship or punishment.",
                "Compelling Amish students to attend school past the eighth grade violates the free exercise clause"
            }
        },
        {
            {
                "Federalist (No.) 10",
                "Brutus (No.) 1",
                "(The) Declaration of Independence",
                "(The) Articles of Confederation",
                "Bill of Rights",
                "Federalist (No.) 51",
                "1st Amendment",
                "2nd Amendment",
                "3rd Amendment",
                "4th Amendment"
            },
            {
                "-Argued that the establishment of a representative democracy is effective against partisanship and factionalism-Shows why founding fathers rejected direct democracy and factionalism (party politics)",
                "-Argued that a free republic cannot govern over a country as large as the United States-States that the government officers would control the people and abuse their power",
                "-States the principles on which the American government is based-Gave reasoning behind a separation from Britain-Establishes that all people are created equal",
                "-First written Constitution of the US-Faults included:1) Could not collect taxes2) Could not regulate trade3) Could not enforce laws4) Needed approval from 9-13 states in order to pass laws5) Amending the document had to have unanimous approval6) No executive branch7) No national court system",
                "-Series of amendments to the Constitution that guarantees individual freedoms and due process",
                "-Addresses means by which appropriate checks and balances can be created in government-Advocates a separation of powers within the national government",
                "Protects the people's right to practice religion, to speak freely, to assemble (meet), to address the government and of the press of publish.",
                "The right to bear arms (Guns).",
                "Guarantees that the army cannot force homeowners to give them room and board.",
                "Protects the people from the government improperly taking property, papers, or people, without a valid warrant based on probably cause (good reason)(Search and Seizure)"
            }
        },
        {
            {
                "House of Representatives",
                "Senate",
                "bicameral",
                "gerrymandering",
                "census",
                "redistricting",
                "reapportionment",
                "two party system",
                "single member districts",
                "entitlements"
            },
            {
                "representatives elected by each state, # depends on population size; advantageous for larger states",
                "2 representatives from each state;advantageous for smaller states",
                "a legislature divided into 2 houses",
                "drawing of congressional districts to favor one political party or group over another",
                "tool for understanding demographic changes; Constitution requires an annual one",
                "redrawing of congressional and other legislative district lines following a census , to accommodate population shifts and keep districts as equal as possible in population",
                "process of reallocating seats in the House every 10 years on the basis of the results of the census",
                "several political parties exist, but only 2 major political parties compete for power and dominate elections",
                "only one representative is chosen from each district",
                "policies for which Congress has obligated itself to pay x level of benefits to y number of recipients (Social Security)"
            }
        }
    };

    //map to convert to user answer choice (A, B, C) to an number
    private final Map<String, Integer> answerChoiceMap = new HashMap<>();

    private int currentAnswer;

    private int rightStreak;
    private int wrongStreak;

    private int lastSetIndex = -1;

    public Question() {
        //sets up the answer choice map
        answerChoiceMap.put("a", 0);
        answerChoiceMap.put("b", 1);
        answerChoiceMap.put("c", 2);
    }

    public void getQuestion() {
        //gets a random question set and random question from that set
        int setIndex = (int)(Math.random() * 3);
        while (setIndex == lastSetIndex) {
            setIndex = (int)(Math.random() * 3);
        }
        lastSetIndex = setIndex;
        int ranQuestion = (int)(Math.random() * questionSets[0][1].length);

        String answer = questionSets[setIndex][0][ranQuestion];
        String question = questionSets[setIndex][1][ranQuestion];

        String[] possibleAnswers = questionSets[setIndex][0];
        String[] choices = new String[3];

        int answerChoiceIndex = (int)(Math.random() * 3);

        currentAnswer = answerChoiceIndex;
        choices[answerChoiceIndex] = answer;

        //already used choices 
        ArrayList<Integer> alreadyUsed = new ArrayList<>();

        //adds in the other random answer choices from the all the set answers, but also checks to make sure it isn't already a choice
        for (int i = 0; i < choices.length; i++) {
            if (i != answerChoiceIndex) {
                int randomChoice = (int)(Math.random() * 10);
                while (isInList(alreadyUsed, randomChoice) || randomChoice == ranQuestion) {
                    randomChoice = (int)(Math.random() * 10);
                }
                alreadyUsed.add(randomChoice);
                choices[i] = possibleAnswers[randomChoice];
            }
        }

        System.out.println();
        System.out.println("Question: " + question);
        System.out.println("     A: " + choices[0]);
        System.out.println("     B: " + choices[1]);
        System.out.println("     C: " + choices[2]);
    }

    public int getRightStreak() {
        return rightStreak;
    }

    private boolean isInList(ArrayList<Integer> list, int num) {
        for (int el : list) {
            if (el == num) {
                return true;
            }
        }
        return false;
    }

    public void printStreaks() {
        System.out.println();
        System.out.println("Right Streak: " + rightStreak);
        System.out.println("Wrong streak: " + wrongStreak);
    }
    
    public void checkAnswer(Enemy npc, Player player, String userChoice) {
        if (answerChoiceMap.get(userChoice.toLowerCase()) == currentAnswer) {
            rightStreak++;
            System.out.println("Good job, that is right!");
            printStreaks();
            player.playerReact(npc, rightStreak);
        } else {
            wrongStreak++;
            System.out.println("WRONG!!!");
            npc.dealDamage(player, wrongStreak);

            player.printHealth();
        }
    }
}
