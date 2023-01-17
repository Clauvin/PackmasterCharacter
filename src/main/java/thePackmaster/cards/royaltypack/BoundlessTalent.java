package thePackmaster.cards.royaltypack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.royaltypack.TributeOrAusterityAction;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.cards.royaltypack.optioncards.BoundlessTalentAusterity;
import thePackmaster.cards.royaltypack.optioncards.BoundlessTalentTribute;
import thePackmaster.cards.royaltypack.optioncards.NobleStrikeAusterity;
import thePackmaster.cards.royaltypack.optioncards.NobleStrikeTribute;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class BoundlessTalent extends AbstractPackmasterCard {

    public final static String ID = makeID("BoundlessTalent");

    public BoundlessTalent() {
        super(ID, 0, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = 5;
        baseSecondMagic = 1;
    }

    @Override
    public void upp() {
        baseSecondMagic += 1;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        AbstractPackmasterCard btTributeChoiceCard = new BoundlessTalentTribute();
        AbstractPackmasterCard btAusterityChoiceCard = new BoundlessTalentAusterity();
        for (int i = 0; i < this.timesUpgraded; i++){
            btTributeChoiceCard.upgrade();
            btAusterityChoiceCard.upgrade();
        }

        Wiz.atb(new TributeOrAusterityAction(btTributeChoiceCard, btAusterityChoiceCard));
    }
}
