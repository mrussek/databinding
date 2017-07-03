package com.mrussek.databinding;

public enum Rating {
    ONE_STAR {
        @Override
        public String toString() {
            return "👎";
        }
    },
    TWO_STARS {
        @Override
        public String toString() {
            return "😔";
        }
    },
    THREE_STARS {
        @Override
        public String toString() {
            return "😐";
        }
    },
    FOUR_STARS {
        @Override
        public String toString() {
            return "🙂";
        }
    },
    FIVE_STARS {
        @Override
        public String toString() {
            return "👍";
        }
    }
}
