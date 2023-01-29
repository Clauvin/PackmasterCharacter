package thePackmaster.cards.royaltypack.optioncards;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.actions.utility.ConditionalDrawAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

@AutoAdd.Ignore
public class NobleStrikeAusterity extends AbstractPackmasterCard {

    public final static String ID = makeID("NobleStrikeAusterity");
    public final static int GOLD_GAINED = 5;

    public NobleStrikeAusterity(){
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
        this.addToBot(new GainGoldAction(GOLD_GAINED));
        this.addToBot(new DrawCardAction(AbstractDungeon.player, magicNumber));
    }
}
