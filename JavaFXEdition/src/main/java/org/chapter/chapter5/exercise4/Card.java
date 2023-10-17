package org.chapter.chapter5.exercise4;

/**
 * Card 클래스는 표준 포커 덱의 플레잉 카드를 나타내며 조커를 포함합니다.
 * 카드는 스페이드, 하트, 다이아몬드, 클럽 또는 조커 중 하나의 모양을 가집니다.
 * 스페이드, 하트, 다이아몬드, 클럽 카드의 값은 ace, 2, 3, 4, 5, 6, 7,
 * 8, 9, 10, jack, queen 또는 king 중 하나입니다.
 * "ace"는 가장 작은 값으로 간주됩니다.
 * 조커에는 연관된 값이 있을 수 있으며, 이 값은 어떤 값이든 될 수 있으며 여러 조커를 추적하는 데 사용할 수 있습니다.
 */
public class Card {

    public final static int SPADES = 0;   // 4개의 모양, 그리고 조커를 위한 코드.
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;
    public final static int JOKER = 4;

    public final static int ACE = 1;      // 숫자가 아닌 카드를 위한 코드.
    public final static int JACK = 11;    //   2에서 10까지의 카드는 그들의
    public final static int QUEEN = 12;   //   코드에 해당하는 숫자 값을 갖습니다.
    public final static int KING = 13;

    /**
     * 이 카드의 모양, 상수 SPADES, HEARTS, DIAMONDS, CLUBS, 또는 JOKER 중 하나입니다.
     * 카드가 생성된 후에는 모양을 변경할 수 없습니다.
     */
    private final int suit;

    /**
     * 카드의 값. 일반 카드의 경우 1에서 13까지의 값 중 하나이며, 1은 ACE를 나타냅니다.
     * 조커의 경우 값은 어떤 값이든 될 수 있습니다. 카드가 생성된 후에는 값이 변경할 수 없습니다.
     */
    private final int value;

    /**
     * 연관된 값 1을 갖는 조커를 생성합니다. (참고: "new Card()"는 "new Card(1,Card.JOKER)"와 동등합니다.)
     */
    public Card() {
        suit = JOKER;
        value = 1;
    }

    /**
     * 지정된 모양과 값으로 카드를 생성합니다.
     * @param theValue 새 카드의 값. 일반 카드 (조커가 아닌 경우)의 경우 값은 1에서 13까지여야 하며, 1은 Ace를 나타냅니다.
     * Card.ACE, Card.JACK, Card.QUEEN 및 Card.KING 상수를 사용할 수 있습니다.
     * 조커의 경우 값은 어떤 값이든 될 수 있습니다.
     * @param theSuit 새 카드의 모양. 이 값은 Card.SPADES, Card.HEARTS, Card.DIAMONDS, Card.CLUBS 또는 Card.JOKER 중 하나여야 합니다.
     * @throws IllegalArgumentException - 매개 변수 값이 허용 범위를 벗어날 경우 발생합니다.
     */
    public Card(int theValue, int theSuit) {
        if (theSuit != SPADES && theSuit != HEARTS && theSuit != DIAMONDS &&
                theSuit != CLUBS && theSuit != JOKER)
            throw new IllegalArgumentException("잘못된 플레잉 카드 모양");
        if (theSuit != JOKER && (theValue < 1 || theValue > 13))
            throw new IllegalArgumentException("잘못된 플레잉 카드 값");
        value = theValue;
        suit = theSuit;
    }

    /**
     * 이 카드의 모양을 반환합니다.
     * @returns 모양, 상수 Card.SPADES, Card.HEARTS, Card.DIAMONDS, Card.CLUBS 또는 Card.JOKER 중 하나
     */
    public int getSuit() {
        return suit;
    }

    /**
     * 이 카드의 값을 반환합니다.
     * @return 값, 일반 카드의 경우 1에서 13까지의 숫자 중 하나이며, 조커의 경우 어떤 값이든 될 수 있습니다.
     */
    public int getValue() {
        return value;
    }

    /**
     * 카드 모양의 문자열 표현을 반환합니다.
     * @return "스페이드", "하트", "다이아몬드", "클럽", 또는 "조커" 중 하나
     */
    public String getSuitAsString() {
        switch ( suit ) {
            case SPADES:   return "스페이드";
            case HEARTS:   return "하트";
            case DIAMONDS: return "다이아몬드";
            case CLUBS:    return "클럽";
            default:       return "조커";
        }
    }

    /**
     * 카드 값의 문자열 표현을 반환합니다.
     * @return 일반 카드의 경우 "Ace", "2", "3", ..., "10", "Jack", "Queen", 또는 "King" 중 하나.
     * 조커의 경우 문자열은 항상 숫자입니다.
     */
    public String getValueAsString() {
        if (suit == JOKER)
            return "" + value;
        else {
            switch ( value ) {
                case 1:   return "Ace";
                case 2:   return "2";
                case 3:   return "3";
                case 4:   return "4";
                case 5:   return "5";
                case 6:   return "6";
                case 7:   return "7";
                case 8:   return "8";
                case 9:   return "9";
                case 10:  return "10";
                case 11:  return "Jack";
                case 12:  return "Queen";
                default:  return "King";
            }
        }
    }

    /**
     * 이 카드의 문자열 표현을 반환합니다. 이 표현에는 모양과 값이 포함됩니다.
     * (값이 1인 조커의 경우 반환값은 "조커"만 됩니다.)
     * 반환 예시: "하트 여왕", "다이아몬드 10", "스페이드 에이스",
     * "조커", "조커 #2"
     */
    public String toString() {
        if (suit == JOKER) {
            if (value == 1)
                return "조커";
            else
                return "조커 #" + value;
        }
        else
            return getValueAsString() + " " + getSuitAsString();
    }


} // end class Card

