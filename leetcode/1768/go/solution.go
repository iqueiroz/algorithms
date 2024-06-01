package solution

import (
	"bytes"
)

func mergeAlternately(word1 string, word2 string) string {
	var buffer bytes.Buffer
	word1Len := len(word1)
	word2Len := len(word2)

	var limit int
	if word1Len < word2Len {
		limit = word1Len
	} else {
		limit = word2Len
	}

	for i := 0; i < limit; i++ {
		buffer.WriteByte(word1[i])
		buffer.WriteByte(word2[i])
	}
	if word1Len < word2Len {
		buffer.WriteString(word2[limit:])
	} else {
		buffer.WriteString(word1[limit:])
	}

	return buffer.String()
}
