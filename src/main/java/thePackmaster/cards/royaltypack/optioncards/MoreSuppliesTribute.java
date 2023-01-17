package thePackmaster.cards.royaltypack.optioncards;

import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.royaltypack.PayTributeAction;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class MoreSuppliesTribute extends AbstractPackmasterCard {

    public final static String ID = makeID("MoreSuppliesTribute");
    public final static int TRIBUTE_GOLD_AMOUNT = 30;

    public MoreSuppliesTribute(){
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
        for (int i = 0; i < AbstractDungeon.player.potionSlots; i++){
            Wiz.atb(new ObtainPotionAction(AbstractDungeon.returnRandomPotion(false)));
        }
    }
}
