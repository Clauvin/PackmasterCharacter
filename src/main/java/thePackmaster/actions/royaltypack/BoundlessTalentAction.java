package thePackmaster.actions.royaltypack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.powers.NightmarePower;

public class BoundlessTalentAction  extends AbstractGameAction {

    private static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("CopyAction");
    private static final String[] TEXT = uiStrings.TEXT;
    private static final float DURATION = 3;

    @Override
    public void update() {
        if (this.duration == DURATION) {
            if (AbstractDungeon.player.hand.isEmpty()) {
                this.isDone = true;
            } else if (AbstractDungeon.player.hand.size() == 1) {
                //Duplicate the only card
                this.isDone = true;
            } else {
                AbstractDungeon.handCardSelectScreen.open(TEXT[0], 1, false, false);
                this.tickDuration();
            }
        } else {
            if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
                AbstractCard tmpCard = AbstractDungeon.handCardSelectScreen.selectedCards.getBottomCard().
                        makeStatEquivalentCopy();
                AbstractDungeon.player.hand.addToHand(tmpCard);
                AbstractDungeon.handCardSelectScreen.selectedCards.clear();
                AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
            }

            this.tickDuration();
        }
    }
}
