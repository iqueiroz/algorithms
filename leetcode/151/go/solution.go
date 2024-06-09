package solution

import (
	"strings"
)

func reverseWords(s string) string {
	splited := strings.Fields(s)

	var sb strings.Builder
	for i := len(splited) - 1; i >= 0; i-- {
		sb.WriteString(splited[i])
		if i > 0 {
			sb.WriteByte(' ')
		}
	}
	return sb.String()
}
