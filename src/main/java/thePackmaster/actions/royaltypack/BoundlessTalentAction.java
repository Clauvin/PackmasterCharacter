package thePackmaster.actions.royaltypack;

import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.powers.NightmarePower;

public class BoundlessTalentAction  extends AbstractGameAction {

    private static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("CopyAction");
    private static final String[] TEXT = uiStrings.TEXT;

    public BoundlessTalentAction() {
        this.duration = Settings.ACTION_DUR_FAST;
        this.actionType = ActionType.WAIT;
    }

    @Override
    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST) {
            if (AbstractDungeon.player.hand.isEmpty()) {
                BaseMod.logger.info("WHAT");
                this.isDone = true;
            } else if (AbstractDungeon.player.hand.size() == 1) {
                BaseMod.logger.info("WHAT 2");
                if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
                    AbstractCard tmpCard = AbstractDungeon.handCardSelectScreen.selectedCards.getBottomCard().
                            makeStatEquivalentCopy();
                    AbstractDungeon.player.hand.addToHand(tmpCard);
                    AbstractDungeon.handCardSelectScreen.selectedCards.clear();
                    AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
                }
                this.isDone = true;
            } else {
                BaseMod.logger.info("YEAH");
                AbstractDungeon.handCardSelectScreen.open("---", 1, false, false);
                this.tickDuration();
            }
        } else {
            BaseMod.logger.info("WHAT 3");
            if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
                if (AbstractDungeon.handCardSelectScreen.selectedCards.size() != 0){
                    AbstractCard tmpCard = AbstractDungeon.handCardSelectScreen.selectedCards.getBottomCard().
                            makeStatEquivalentCopy();
                    AbstractDungeon.player.hand.addToHand(tmpCard);
                    AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = false;
                    AbstractDungeon.handCardSelectScreen.selectedCards.clear();
                    BaseMod.logger.info("WHAT 4");
                    this.isDone = true;
                }
            }
        }
    }
}
