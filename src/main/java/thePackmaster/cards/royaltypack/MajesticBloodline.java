package thePackmaster.cards.royaltypack;

import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.royaltypack.TributeOrAusterityAction;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.cards.royaltypack.optioncards.MajesticBloodlineAusterity;
import thePackmaster.cards.royaltypack.optioncards.MajesticBloodlineTribute;
import thePackmaster.cards.royaltypack.optioncards.ThrowSoulstonesAusterity;
import thePackmaster.cards.royaltypack.optioncards.ThrowSoulstonesTribute;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class MajesticBloodline extends AbstractPackmasterCard {

    public final static String ID = makeID("MajesticBloodline");
    public final static int BASE_AMOUNT_OF_POWER_CHOICES = 3;

    public MajesticBloodline(){
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        exhaust = true;
        baseMagicNumber = magicNumber = BASE_AMOUNT_OF_POWER_CHOICES;
    }

    @Override
    public void upp() {
        upgradeMagicNumber(2);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        //Create action for shuffling card after Discovery type effect
        AbstractPackmasterCard mbTributeChoiceCard = new MajesticBloodlineTribute(this);
        AbstractPackmasterCard mbAusterityChoiceCard = new MajesticBloodlineAusterity();

        Wiz.atb(new TributeOrAusterityAction(mbTributeChoiceCard, mbAusterityChoiceCard));
    }

    private void CreatePowers(int amount){
        CardGroup powersToChooseFrom = new CardGroup(CardGroup.CardGroupType.CARD_POOL);
        //Group power cards from packs currently chosen
        for (int i = 0; i < amount; i++){
            //Select a random power card
            //If card is the same as some other already chosen, repeat
        }

    }


}
