package thePackmaster.cards.royaltypack;

import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class WindShield extends AbstractPackmasterCard {
    public final static String ID = makeID("WindShield");

    public WindShield(){
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = 4;
    }

    @Override
    public void upp() {
        baseBlock += 2;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        int currentHandSize = abstractPlayer.hand.size();
        this.addToBot(new DiscardAction(abstractPlayer, abstractPlayer, currentHandSize, false));
        //Create Action to Gain Block N Times, where N is an amount of cards discarded.
    }
}
