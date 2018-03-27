CURRENT_DIR=$$(pwd)

.PHONY: report
report:
	${CURRENT_DIR}/bin/gatling.sh -rf ${CURRENT_DIR}/results -ro $$(ls -t "${CURRENT_DIR}"/results | head -n1)
	open ${CURRENT_DIR}/results/$$(ls -t "${CURRENT_DIR}"/results | head -n1)/index.html
