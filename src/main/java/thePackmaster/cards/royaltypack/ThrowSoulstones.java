package thePackmaster.cards.royaltypack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.royaltypack.TributeOrAusterityAction;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.cards.royaltypack.optioncards.NobleStrikeAusterity;
import thePackmaster.cards.royaltypack.optioncards.NobleStrikeTribute;
import thePackmaster.cards.royaltypack.optioncards.ThrowSoulstonesAusterity;
import thePackmaster.cards.royaltypack.optioncards.ThrowSoulstonesTribute;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class ThrowSoulstones extends AbstractPackmasterCard {

    public final static String ID = makeID("ThrowSoulstones");
    public final static int AUSTERITY_DAMAGE = 5;
    public final static int TRIBUTE_DAMAGE = 15;

    public ThrowSoulstones(){
        super(ID, 0, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY);
        baseDamage = damage = 5;
        baseMagicNumber = magicNumber = 15;
        baseSecondMagic = secondMagic = 0;
    }

    @Override
    public void upp() {
        this.upgradeMagicNumber(5);
        secondMagic += 1;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        AbstractPackmasterCard tsTributeChoiceCard = new ThrowSoulstonesTribute(this);
        AbstractPackmasterCard tsAusterityChoiceCard = new ThrowSoulstonesAusterity();
        for (int i = 0; i <= secondMagic - 1; i++){
            tsTributeChoiceCard.upgrade();
            tsAusterityChoiceCard.upgrade();
        }

        Wiz.atb(new TributeOrAusterityAction(tsTributeChoiceCard, tsAusterityChoiceCard));
    }
}
