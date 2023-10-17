package org.chapter.chapter5.exercise4;

public class BlackjackHand extends Hand {

    /**
     * 블랙잭 게임에서 이 핸드의 값을 계산하고 반환합니다.
     */
    public int getBlackjackValue() {

        int val;      // 핸드에 대한 계산된 값.
        boolean ace;  // 핸드에 Ace(에이스)가 포함되어 있는 경우 true로 설정.
        int cards;    // 핸드 내의 카드 수.

        val = 0;
        ace = false;
        cards = getCardCount();  // (Hand 클래스에 정의된 메서드.)

        for ( int i = 0;  i < cards;  i++ ) {
            // 핸드 내의 i번째 카드의 값을 추가합니다.
            Card card;    // i번째 카드.
            int cardVal;  // i번째 카드의 블랙잭 값.
            card = getCard(i);
            cardVal = card.getValue();  // 일반 값, 1에서 13까지.
            if (cardVal > 10) {
                cardVal = 10;   // Jack(잭), Queen(퀸), 또는 King(킹)인 경우.
            }
            if (cardVal == 1) {
                ace = true;     // 하나 이상의 Ace가 있습니다.
            }
            val = val + cardVal;
        }

        // 이제 val은 Ace를 1로 세는 상태에서의 핸드 값입니다.
        // Ace가 있고 그 값을 1에서 11로 변경하면 점수가 21보다 작거나 같다면
        // 10점을 추가하여 변경합니다.

        if ( ace == true  &&  val + 10 <= 21 )
            val = val + 10;

        return val;

    }  // end getBlackjackValue()

} // end class BlackjackHand
