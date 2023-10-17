package org.chapter.chapter5.exercise4;

/**
 * Deck 클래스는 플레잉 카드 덱을 나타냅니다. 덱은 52장의 일반 카드와 선택적으로 두 개의 조커를 포함할 수 있는
 * 보통의 포커 덱입니다.
 */
public class Deck {

    /**
     * 52 또는 54장의 카드 배열입니다. 54장 덱은 52장의 보통 카드와 두 개의 조커를 포함합니다.
     */
    private Card[] deck;

    /**
     * 지금까지 덱에서 사용된 카드의 수를 추적합니다.
     */
    private int cardsUsed;

    /**
     * 보통의 52장 포커 덱을 생성합니다. 처음에 카드는 정렬된 순서입니다. shuffle() 메서드를 호출하여
     * 순서를 무작위로 섞을 수 있습니다. (참고: "new Deck()"는 "new Deck(false)"와 동등합니다.)
     */
    public Deck() {
        this(false);  // 이 클래스의 다른 생성자를 호출합니다.
    }

    /**
     * 플레잉 카드 덱을 생성합니다. 덱에는 보통 52장의 카드와 선택적으로 두 개의 조커가 포함됩니다.
     * 처음에 카드는 정렬된 순서입니다. shuffle() 메서드를 호출하여 순서를 무작위로 섞을 수 있습니다.
     * @param includeJokers true인 경우 덱에 두 개의 조커가 포함되며, false인 경우 덱에 조커가 없습니다.
     */
    public Deck(boolean includeJokers) {
        if (includeJokers)
            deck = new Card[54];
        else
            deck = new Card[52];
        int cardCt = 0; // 지금까지 생성된 카드 수.
        for (int suit = 0; suit <= 3; suit++) {
            for (int value = 1; value <= 13; value++) {
                deck[cardCt] = new Card(value, suit);
                cardCt++;
            }
        }
        if (includeJokers) {
            deck[52] = new Card(1, Card.JOKER);
            deck[53] = new Card(2, Card.JOKER);
        }
        cardsUsed = 0;
    }

    /**
     * 사용된 카드를 모두 덱에 돌려놓고 덱을 무작위로 섞습니다.
     */
    public void shuffle() {
        for (int i = deck.length - 1; i > 0; i--) {
            int rand = (int) (Math.random() * (i + 1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardsUsed = 0;
    }

    /**
     * 덱에서 나눠진 카드의 수를 반환합니다. 덱에서 남은 카드 수입니다.
     * 덱이 처음 생성되었거나 덱이 섞인 후에는 52 또는 54 (덱에 조커가 포함되는지 여부에 따라 다름)입니다.
     * dealCard() 메서드를 호출할 때마다 1씩 감소합니다.
     */
    public int cardsLeft() {
        return deck.length - cardsUsed;
    }

    /**
     * 덱에서 다음 카드를 제거하고 반환합니다. 덱에 더 이상 카드가 없을 경우 이 메서드를 호출하는 것은
     * 잘못된 것입니다. 남은 카드 수를 확인하려면 cardsLeft() 함수를 호출할 수 있습니다.
     * @return 덱에서 제거된 카드
     * @throws IllegalStateException - 덱에 더 이상 카드가 없는 경우 예외 발생
     */
    public Card dealCard() {
        if (cardsUsed == deck.length)
            throw new IllegalStateException("덱에 더 이상 카드가 없습니다.");
        cardsUsed++;
        return deck[cardsUsed - 1];
        // 프로그래밍 참고: 덱을 나타내는 배열에서 카드가 실제로 제거되는 것은 아닙니다.
        // 그저 사용된 카드 수를 추적할 뿐입니다.
    }

    /**
     * 덱에 조커가 포함되어 있는지 여부를 확인합니다.
     * @return true이면 두 개의 조커를 포함하는 54장 덱이거나, false이면 조커가 없는 52장 덱입니다.
     */
    public boolean hasJokers() {
        return (deck.length == 54);
    }

} // end class Deck

