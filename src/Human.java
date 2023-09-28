import java.util.Random;

public class Human extends Mob {
    private Random random;

    public Human() {
        super();

        cultivationRanks = new String[] {"Qi Foundation", "Golden Core", "Nascent Soul", "Void Tribulation", "Ascension"};
        currentRank = 0;
        currentSubrank = 1;

        random = new Random();
        talent = random.nextInt(99) + 1;

        strengh = random.nextInt(10);
        agility = random.nextInt(10);
        inteligence = random.nextInt(10);
        durability = random.nextInt(10);

        qi_capacity = random.nextInt(5000) + 5000;
        qi_amount = qi_capacity / 2;
        qi_intensity = random.nextInt(10);

        breakthroughQiReq = qi_capacity * 2;

        age = 10;
    }

    public void cultivate(int areaQiDensity) {
        qi_amountInc = (int)((areaQiDensity * (4 * qi_intensity) + inteligence * 7) / (qi_capacity * 0.03)) + (talent * inteligence);
        qi_amount += qi_amountInc;

        strenghInc = random.nextInt(3 * (currentRank+currentSubrank));
        inteligenceInc = random.nextInt(3 * (currentRank+currentSubrank));
        agilityInc = random.nextInt(3 * (currentRank+currentSubrank));
        durabilityInc = random.nextInt(3 * (currentRank+currentSubrank));

        strengh += strenghInc;
        inteligence += inteligenceInc;
        agility += agilityInc;
        durability += durabilityInc;

        age++;

        healthInc = (int)((strengh / 2) * durability) + (talent * durability);
        health+=healthInc;
    }

    public boolean breakthrough() {
        int successScore = 0;
        int successReq = 0;

        if (qi_amount >= qi_capacity) {
            successReq = 80;
        } else {
            successReq = 120;
        }

        successScore = talent + (120 / (qi_capacity / Math.min(qi_amount, qi_capacity)));

        if (successScore >= successReq) {
            applyBreakthrough();
            return true;
        }

        return false;
    }

    private void applyBreakthrough() {
        qi_amount /= 2;

        if (currentSubrank >= 9) {
            currentRank++;
            currentSubrank = 1;

            applyMajorBreakthrough();
            return;
        } else {
            currentSubrank++;
        }

        qi_capacity *= 3;

        strenghInc     = (random.nextInt(2)+1) * strengh;
        agilityInc     = (random.nextInt(2)+1) * agility;
        inteligenceInc = (random.nextInt(2)+1) * durability;
        durabilityInc  = (random.nextInt(2)+1) * durability;
        healthInc      = (random.nextInt(3)+1) * health;

        strengh += strenghInc;
        agility += agilityInc;
        inteligence += inteligenceInc;
        durability += durabilityInc;
        health += healthInc;

        talentInc = random.nextInt(10);
        talent += talentInc;
    }

    private void applyMajorBreakthrough() {
        strenghInc     = (random.nextInt(3)+4) * strengh;
        agilityInc     = (random.nextInt(3)+4) * agility;
        inteligenceInc = (random.nextInt(3)+4) * inteligence;
        durabilityInc  = (random.nextInt(3)+4) * durability;
        healthInc = 5 * health;
        talentInc = random.nextInt(15);

        qi_capacity *= 5;
        strengh += strenghInc;
        agility += agilityInc;
        inteligence += inteligenceInc;
        durability += durabilityInc;
        health += healthInc;

        talent += talentInc;
    }
}
