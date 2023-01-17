package thePackmaster.cards.royaltypack.optioncards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.royaltypack.BoundlessTalentAction;
import thePackmaster.actions.royaltypack.PayTributeAction;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class BoundlessTalentTribute extends AbstractPackmasterCard {

    public final static String ID = makeID("BoundlessTalentTribute");
    public final static int TRIBUTE_GOLD_AMOUNT = 5;

    public BoundlessTalentTribute(){
        super(ID, -2, CardType.STATUS, CardRarity.SPECIAL, CardTarget.SELF);
    }

    @Override
    public void upp() {

    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        onChoseThisOption();
    }

    @Override
    public void onChoseThisOption() {
        Wiz.atb(new PayTributeAction(TRIBUTE_GOLD_AMOUNT));
        Wiz.atb(new BoundlessTalentAction());
    }



}
