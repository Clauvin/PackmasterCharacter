package thePackmaster.cards.royaltypack;

import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class WindShield extends AbstractPackmasterCard {
    public final static String ID = makeID("WindShield");
    public final static int BLOCK_GIVEN_BY_DISCARD = 4;

    public WindShield(){
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = block =  BLOCK_GIVEN_BY_DISCARD;
    }

    @Override
    public void upp() {
        upgradeBlock(2);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        int currentHandSize = abstractPlayer.hand.size();
        this.addToBot(new DiscardAction(abstractPlayer, abstractPlayer, currentHandSize, false));
        //Create Action to Gain Block N Times, where N is an amount of cards discarded.
    }
}
