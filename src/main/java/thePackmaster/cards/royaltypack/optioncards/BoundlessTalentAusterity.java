package thePackmaster.cards.royaltypack.optioncards;

import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.FastDrawCardAction;
import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class BoundlessTalentAusterity extends AbstractPackmasterCard {

    public final static String ID = makeID("BoundlessTalentAusterity");

    public BoundlessTalentAusterity(){
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
        //BaseMod.logger.info(AbstractDungeon.player.hand.size());
        int amountOfCardsToDraw = 10 - AbstractDungeon.player.hand.size();
        for (int i = 0; i < amountOfCardsToDraw; i++){
            Wiz.atb(new DrawCardAction(AbstractDungeon.player, 1));
        }

    }
}
