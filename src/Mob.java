public class Mob {
    protected int qi_amount;
    protected int qi_intensity;
    protected int qi_capacity;

    protected int qi_amountInc;

    protected int health;
    protected int strengh;
    protected int agility;
    protected int durability;
    protected int inteligence;
    
    protected int healthInc;
    protected int strenghInc;
    protected int agilityInc;
    protected int durabilityInc;
    protected int inteligenceInc;

    protected int talent;
    protected int talentInc;

    protected String[] cultivationRanks;
    protected int currentRank;
    protected int currentSubrank;

    protected int breakthroughQiReq;

    protected int age;

    public Mob() {

    }

    public int getQiAmount() {return qi_amount;}
    public int getQiIntensity() {return qi_intensity;}
    public int getQiCapacity() {return qi_capacity;}

    public int getQiAmountInc() {return qi_amountInc;}

    public int getHealth() {return health;}
    public int getStrengh() {return strengh;}
    public int getAgility() {return agility;}
    public int getDurability() {return durability;}
    public int getInteligence() {return inteligence;}

    public int getHealthInc() {return healthInc;}
    public int getStrenghInc() {return strenghInc;}
    public int getAgilityInc() {return agilityInc;}
    public int getDurabilityInc() {return durabilityInc;}
    public int getInteligenceInc() {return inteligenceInc;}

    public int getTalent() {return talent;}
    public int getTalentInc() {return talentInc;}

    public String getCultivationStage() {
        return cultivationRanks[currentRank] + " Stage " + currentSubrank;
    }
    public int getCurrentStage() {return currentSubrank;}

    public int getBreakthroughQiReq() {return breakthroughQiReq;}

    public int getAge() {return age;}
}
