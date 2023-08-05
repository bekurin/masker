package kr.masker.core;

import kr.masker.core.util.Replacement;

public interface Masker {
    String process(CharSequence input, Replacement replacement);
}
