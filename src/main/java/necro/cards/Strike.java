package necro.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import necro.character.Necro;
import necro.util.CardStats;

public class Strike extends BaseCard {
    public static final String ID = makeID("Strike"); //makeID adds the mod ID, so the final ID will be something like "modID:MyCard"
    private static final CardStats info = new CardStats(
        Necro.Meta.CARD_COLOR,
        CardType.ATTACK,
        CardRarity.BASIC, // basic is for starting cards.
        CardTarget.ENEMY,
        1 // the base cost, -1 is X and -2 is unplayable.
    );
    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 3;

    public Strike() {
        super(ID, info);
        setDamage(DAMAGE, UPG_DAMAGE);

        tags.add(CardTags.STARTER_STRIKE);
        tags.add(CardTags.STRIKE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(
            new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL)
        );
    }
}
