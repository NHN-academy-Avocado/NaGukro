package org.chapter.chapter5.exercise5;

/**
 * Hand 클래스의 객체는 카드의 핸드를 나타냅니다. 카드는 Card 클래스에 속합니다. 핸드는 처음에는
 * 비어있으며 어떤 수의 카드든 추가할 수 있습니다.
 */

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;   // 핸드 내의 카드.

    /**
     * 초기에 비어있는 핸드를 생성합니다.
     */
    public Hand() {
        hand = new ArrayList<Card>();
    }

    /**
     * 핸드에서 모든 카드를 제거하여 비웁니다.
     */
    public void clear() {
        hand.clear();
    }

    /**
     * 핸드에 카드를 추가합니다. 카드는 현재 핸드의 끝에 추가됩니다.
     * @param c 추가할 비어 있지 않은 카드.
     * @throws NullPointerException - 파라미터 c가 null인 경우 예외 발생.
     */
    public void addCard(Card c) {
        if (c == null)
            throw new NullPointerException("핸드에 null 카드를 추가할 수 없습니다.");
        hand.add(c);
    }

    /**
     * 핸드에서 카드를 제거합니다. (만약 카드가 핸드에 없거나 c가 null인 경우 아무 작업도 수행하지 않습니다.)
     * @param c 제거할 카드. c가 null이거나 카드가 핸드에 없는 경우 아무 작업도 수행되지 않습니다.
     */
    public void removeCard(Card c) {
        hand.remove(c);
    }

    /**
     * 핸드에서 지정된 위치의 카드를 제거합니다.
     * @param position 제거할 카드의 위치. 위치는 0부터 시작합니다.
     * @throws IllegalArgumentException - 위치가 핸드에 존재하지 않는 경우 예외 발생합니다.
     * 위치가 0보다 작거나 핸드 내의 카드 수 이상인 경우입니다.
     */
    public void removeCard(int position) {
        if (position < 0 || position >= hand.size())
            throw new IllegalArgumentException("핸드에 위치가 존재하지 않습니다: " + position);
        hand.remove(position);
    }

    /**
     * 핸드 내의 카드 수를 반환합니다.
     */
    public int getCardCount() {
        return hand.size();
    }

    /**
     * 핸드에서 지정된 위치의 카드를 가져옵니다. (참고: 이 카드는 핸드에서 제거되지 않습니다!)
     * @param position 반환할 카드의 위치
     * @throws IllegalArgumentException - 위치가 핸드에 존재하지 않는 경우 예외 발생합니다.
     */
    public Card getCard(int position) {
        if (position < 0 || position >= hand.size())
            throw new IllegalArgumentException("핸드에 위치가 존재하지 않습니다: " + position);
        return hand.get(position);
    }

    /**
     * 핸드 내의 카드를 동일한 모양(무늬)을 가진 카드끼리 그룹화하고, 모양 내에서 카드를 값에 따라 정렬합니다.
     * 여기서 주의할 점은 Ace(에이스)가 가장 낮은 값인 1로 간주됩니다.
     */
    public void sortBySuit() {
        ArrayList<Card> newHand = new ArrayList<Card>();
        while (hand.size() > 0) {
            int pos = 0;  // 최소 카드의 위치.
            Card c = hand.get(0);  // 최소 카드.
            for (int i = 1; i < hand.size(); i++) {
                Card c1 = hand.get(i);
                if (c1.getSuit() < c.getSuit() ||
                        (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue())) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }

    /**
     * 핸드 내의 카드를 값에 따라 동일한 값을 가진 카드끼리 그룹화합니다. 동일한 값을 가진 카드는 모양에 따라 정렬됩니다.
     * 여기서 주의할 점은 Ace(에이스)가 가장 낮은 값인 1로 간주됩니다.
     */
    public void sortByValue() {
        ArrayList<Card> newHand = new ArrayList<Card>();
        while (hand.size() > 0) {
            int pos = 0;  // 최소 카드의 위치.
            Card c = hand.get(0);  // 최소 카드.
            for (int i = 1; i < hand.size(); i++) {
                Card c1 = hand.get(i);
                if (c1.getValue() < c.getValue() ||
                        (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit())) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }

}
