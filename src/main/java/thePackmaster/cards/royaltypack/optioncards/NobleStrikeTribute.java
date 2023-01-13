package thePackmaster.cards.royaltypack.optioncards;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.unique.AttackFromDeckToHandAction;
import com.megacrit.cardcrawl.actions.utility.ConditionalDrawAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.royaltypack.DrawSpecificCardTypeAction;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import javax.smartcardio.Card;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class NobleStrikeTribute extends AbstractPackmasterCard {

    public final static String ID = makeID("NobleStrikeTribute");
    public final static int TRIBUTE_GOLD_AMOUNT = 5;

    public NobleStrikeTribute(){
        super(ID, -2, CardType.STATUS, CardRarity.SPECIAL, CardTarget.SELF);
        baseMagicNumber = magicNumber = 1;
    }

    @Override
    public void upp() {
        this.upgradeMagicNumber(1);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        onChoseThisOption();
    }

    @Override
    public void onChoseThisOption(){
        //Add PayTributeAction
        for (int i = 0; i < magicNumber; i++){
            Wiz.atb(new DrawSpecificCardTypeAction(CardType.ATTACK));
        }
    }
}
