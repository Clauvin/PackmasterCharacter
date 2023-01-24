package thePackmaster.actions.royaltypack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.GainGoldTextEffect;
import thePackmaster.util.Wiz;
import thePackmaster.vfx.royaltypack.LoseGoldTextEffect;

import javax.swing.*;
import java.util.ArrayList;

public class PayTributeAction extends AbstractGameAction {

    private int amountToPay;

    public PayTributeAction(int amountToPay) {
        this.duration = Settings.ACTION_DUR_FAST;
        this.actionType = ActionType.WAIT;
        this.amountToPay = amountToPay;
    }

    @Override
    public void update() {
        int currentPlayerGold = AbstractDungeon.player.gold;
        if (currentPlayerGold >= amountToPay){
            AbstractDungeon.effectList.add(new LoseGoldTextEffect(-amountToPay));
            AbstractDungeon.player.loseGold(amountToPay);
        }
        else {
            int trueGoldAmountToLose = currentPlayerGold;
            AbstractDungeon.effectList.add(new LoseGoldTextEffect(-trueGoldAmountToLose));
            AbstractDungeon.player.loseGold(trueGoldAmountToLose);
            int HPToLose = amountToPay - trueGoldAmountToLose;
            if (HPToLose > 0){
                Wiz.atb(new LoseHPAction(AbstractDungeon.player, AbstractDungeon.player, HPToLose));
            }
        }

        this.isDone = true;
    }
}
