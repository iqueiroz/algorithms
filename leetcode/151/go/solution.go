package solution

import (
	"strings"
)

func reverseWords(s string) string {
	splitfunc := func(c rune) bool {
		return c == ' '
	}
	splited := strings.FieldsFunc(s, splitfunc)

	var sb strings.Builder
	for i := len(splited) - 1; i >= 0; i-- {
		sb.WriteString(splited[i])
		if i > 0 {
			sb.WriteByte(' ')
		}
	}
	return sb.String()
}
