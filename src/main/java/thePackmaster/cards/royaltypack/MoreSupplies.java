package thePackmaster.cards.royaltypack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.royaltypack.TributeOrAusterityAction;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.cards.royaltypack.optioncards.MoreSuppliesAusterity;
import thePackmaster.cards.royaltypack.optioncards.MoreSuppliesTribute;
import thePackmaster.cards.royaltypack.optioncards.WillpowerAusterity;
import thePackmaster.cards.royaltypack.optioncards.WillpowerTribute;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class MoreSupplies extends AbstractPackmasterCard {

    public final static String ID = makeID("MoreSupplies");

    public MoreSupplies(){
        super(ID, 2, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        this.tags.add(CardTags.HEALING);
    }

    @Override
    public void upp() {
        upgradeBaseCost(this.cost - 1);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        AbstractPackmasterCard moreSuppliesTributeChoiceCard = new MoreSuppliesTribute();
        AbstractPackmasterCard moreSuppliesAusterityChoiceCard = new MoreSuppliesAusterity();
        if (this.upgraded){
            moreSuppliesTributeChoiceCard.upgrade();
            moreSuppliesAusterityChoiceCard.upgrade();
        }

        Wiz.atb(new TributeOrAusterityAction(moreSuppliesTributeChoiceCard, moreSuppliesAusterityChoiceCard));
    }
}
