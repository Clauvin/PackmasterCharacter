package thePackmaster.actions.royaltypack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;

public class TributeOrAusterityAction extends AbstractGameAction {
    private ArrayList<AbstractCard> choices;

    public TributeOrAusterityAction(AbstractCard tribute, AbstractCard austerity) {
        this.duration = Settings.ACTION_DUR_FAST;
        this.actionType = ActionType.WAIT;
    }

    @Override
    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST) {
            AbstractDungeon.cardRewardScreen.chooseOneOpen(this.choices);
            tickDuration();
            return;
        }
        tickDuration();
    }
}
